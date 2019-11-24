/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.lexico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Hairt,Versus and Stacks
 */
public class Analex
{
    private BufferedReader arquivo;
    private String arquivoNome;
    private String linha;
    private int numeroLinha;
    private int posicaoLinha;

    public Analex()
    {
        this.arquivo=null;
        this.arquivoNome="";
        this.linha= "";
        this.numeroLinha=0;
        this.posicaoLinha=0;
    }
    public Analex(String nomeArquivo) throws IOException
    {
        this.arquivo= new BufferedReader(new FileReader(nomeArquivo));
        this.arquivoNome=nomeArquivo;
        this.linha=arquivo.readLine().concat("\n");
        this.numeroLinha=1;
        this.posicaoLinha=0;
    }
    public void abreArquivo(String nomeArquivo) throws IOException
    {
        this.arquivo = new BufferedReader(new FileReader(nomeArquivo));
        this.arquivoNome = nomeArquivo;
        this.linha = arquivo.readLine().concat("\n");
        this.numeroLinha = 1;
        this.posicaoLinha = 0;
    }
    public void fechaArquivo() throws IOException
    {
        this.arquivo.close();
        this.linha = "";
        this.numeroLinha = 0;
        this.posicaoLinha = 0;
    }
    private char lerCaracter()
    {
        if(linha == null)
            return 0;

        if(posicaoLinha == linha.length())
        {
            try
            {
                linha=arquivo.readLine();
                if(linha == null)//casol leu o fim do arquivo
                {
                    numeroLinha++;
                    return 0;
                }
                linha = linha.concat("\n");
                numeroLinha++;
                posicaoLinha = 0;
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        char ch = linha.charAt(posicaoLinha);
        posicaoLinha++;
        return ch;
    }
    private boolean verificaProximoChar(char ch)
    {
        char nextChar = lerCaracter();
        return ch == nextChar;
    }

    private char getNextChar(){
        if(linha == null)
            return 0;

        if(posicaoLinha == linha.length())
        {
            try
            {
                linha=arquivo.readLine();
                if(linha == null)//casol leu o fim do arquivo
                {
                   // numeroLinha++;
                    return 0;
                }
                linha = linha.concat("\n");
                //numeroLinha++;
                posicaoLinha = 0;
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        char ch = linha.charAt(posicaoLinha);
        return ch;
    }
    private void getNewLine()
    {
        try
        {
            linha = arquivo.readLine();
            if(linha != null)
                linha.concat("\n");
            posicaoLinha = 0;
            numeroLinha++;
        } catch(IOException e)
        {
            e.printStackTrace();
        }


    }
    public Token getToken()
    {
        Token token = null;
        EstadosAutomato estado = EstadosAutomato.NAO_ALFANUMERICO;
        String lexema = "";
        char ch;
        while(token == null)
        {
            switch(estado)
            {
                case NAO_ALFANUMERICO:
                    ch = lerCaracter();

                    switch(ch)
                    {
                        case '|':
                            token = new Token(Tokens.OR,"|",numeroLinha);
                            break;
                        case '!':
                            token = new Token(Tokens.OR,"!",numeroLinha);
                            break;
                        case '.':
                            token = new Token(Tokens.PONTO,".",numeroLinha);
                            break;
                        case ';':
                            token = new Token(Tokens.PONTOVIRGULA,";",numeroLinha);
                            break;
                        case ',':
                            token = new Token(Tokens.VIRGULA,",",numeroLinha);
                            break;
                        case '(':
                            if( getNextChar()== ')')
                            {

                               token = new Token(Tokens.ABREFECHAPAR,"()",numeroLinha);
                            }
                            else{
                                if(getNextChar()== '*')
                                {
                                    //posicaoLinha--;

                                    estado=EstadosAutomato.COMENTARIO;
                                    lexema= String.valueOf(ch);

                                }else{
                                        //posicaoLinha--;
                                        token = new Token(Tokens.ABREPAR,"(",numeroLinha);
                                     }
                            }
                            break;
                        case ')':
                            token = new Token(Tokens.FECHAPAR,")",numeroLinha);
                            break;
                        case '[':
                            token = new Token(Tokens.ABRERET,"[",numeroLinha);
                            break;
                        case ']':
                            token = new Token(Tokens.FECHARET,"]",numeroLinha);
                            break;
                        case '*':
                                token = new Token(Tokens.VEZES,"*",numeroLinha);
                            break;
                        case '=':
                            token = new Token(Tokens.IGUAL,"=",numeroLinha);
                            break;
                        case '>':
                            if(verificaProximoChar('='))
                                token = new Token(Tokens.MAIORIGUAL,">=",numeroLinha);
                            else
                            {
                                posicaoLinha--;
                                token = new Token(Tokens.MAIOR,">",numeroLinha);
                            }
                            break;
                        case '<':
                            if(verificaProximoChar('='))
                                token = new Token(Tokens.MAIORIGUAL,"<=",numeroLinha);
                            else
                            {
                                posicaoLinha--;
                                if(verificaProximoChar('>'))
                                    token = new Token(Tokens.DIFERENTE,"<>",numeroLinha);
                                else
                                {
                                    posicaoLinha--;
                                    token = new Token(Tokens.MENOR,"<",numeroLinha);
                                }
                            }
                            break;
                        case '+':
                                token = new Token(Tokens.MAIS,"+",numeroLinha);
                            break;
                        case '-':
                                token = new Token(Tokens.MENOS,"-",numeroLinha);
                            break;
                        case '/':
                            if(getNextChar()== '*'){
                               estado=EstadosAutomato.COMENTARIO;
                               lexema= String.valueOf(ch);
                            }
                            else
                            {
                                posicaoLinha--;
                                token = new Token(Tokens.DIVISAO,"/",numeroLinha);
                            }
                            break;
                        case '~':
                            token = new Token(Tokens.NOT,"~",numeroLinha);
                            break;
                        case ':':
                            if(this.verificaProximoChar('='))
                            token = new Token(Tokens.DOISPONTOSIGUAL,":=",numeroLinha);
                            else
                            {
                                posicaoLinha--;
                                token = new Token(Tokens.DOISPONTOS,":",numeroLinha);
                            }
                            break;
                        case '&':
                            token = new Token(Tokens.AND,"&",numeroLinha);
                            break;
                        case '"':
                            while(true){
                                ch = lerCaracter();
                                //lexema+=String.valueOf(ch);

                                    if(ch=='"')
                                    {
                                        estado=EstadosAutomato.NAO_ALFANUMERICO;
                                        //getNewLine();
                                        break;
                                    }


                                }
                            break;
                        case '{':
                            while(true){
                                ch = lerCaracter();
                                    if(ch=='}')
                                    {
                                        estado=EstadosAutomato.NAO_ALFANUMERICO;
                                        break;
                                    }


                                }
                            break;
                        default:
                             if(ch == ' ' || ch =='\n' || ch == '\t')
                                 continue;
                             else if(ch == 0)
                                 token = new Token(Tokens.EOF,"",numeroLinha);
                             else if(ch == '\'')
                             {
                                 estado = EstadosAutomato.STRING;
                                 lexema= String.valueOf(ch);
                             }
                             else if(Character.isLetter(ch))
                             {
                                 estado = EstadosAutomato.IDENTIFICADOR;
                                 lexema = String.valueOf(ch);
                             }
                             else if(Character.isDigit(ch))
                             {
                                 estado = EstadosAutomato.NUM_INTEIRO;
                                 lexema = String.valueOf(ch);
                             }
                             else if((ch == '{')||(ch == '"'))
                             {
                                 estado = EstadosAutomato.COMENTARIO;
                                 lexema = String.valueOf(ch);
                             }else if(ch == '(')
                             {
                                 if(verificaProximoChar('*'))
                                 {
                                     estado = EstadosAutomato.COMENTARIO;
                                     lexema=String.valueOf(ch);
                                 }
                             }
                             else
                             {
                                 estado = EstadosAutomato.ERRO;
                                 lexema = String.valueOf(ch);
                             }
                            break;

                    }
                break;
                case NUM_INTEIRO:
                    ch= lerCaracter();
                    if(ch!='.' && Delimitadores.isDelimiter(ch))
                    {
                        token = new Token(Tokens.NUMINT,lexema,numeroLinha);
                        posicaoLinha--;
                    }
                    else
                    {
                        if(ch =='.')
                        {
                            estado = EstadosAutomato.NUM_REAL_DECIMAL;
                            lexema += String.valueOf('.');
                            continue;
                        }
                        else if(ch == 'e')
                        {
                            estado = EstadosAutomato.NUM_REAL_EXP;
                            lexema += String.valueOf('e');
                            continue;
                        }
                        else if(Character.isDigit(ch))
                             lexema += String.valueOf(ch);
                        else
                        {
                            estado = EstadosAutomato.ERRO;
                            lexema +=String.valueOf(ch);
                            continue;
                        }


                    }
                break;
                case NUM_REAL_DECIMAL:
                    ch=lerCaracter();
                    if(ch!='.' && Delimitadores.isDelimiter(ch))
                    {
                        token = new Token(Tokens.NUMREAL,lexema,numeroLinha);
                        posicaoLinha--;
                    }
                    else
                    {
                        if(ch == 'e')
                        {
                            estado = EstadosAutomato.NUM_REAL_EXP;
                            lexema +=String.valueOf('e');
                            continue;
                        }
                        else if(Character.isDigit(ch))
                            lexema += String.valueOf(ch);
                        else
                        {
                            estado = EstadosAutomato.ERRO;
                            lexema += String.valueOf(ch);
                            continue;

                        }

                    }
                break;
                case NUM_REAL_EXP:
                    ch = lerCaracter();
                    if(Delimitadores.isDelimiter(ch) && lexema.charAt(lexema.length()-1) != 'e')
                    {
                        if(Character.isDigit(lexema.charAt(lexema.length()-1)))
                            token = new Token(Tokens.NUMREAL,lexema,numeroLinha);
                        else
                            token = new Token(Tokens.ERRO,lexema,numeroLinha);

                        posicaoLinha--;
                    }
                    else
                    {
                        if(ch == '+' || ch == '-')
                        {
                            if(lexema.charAt(lexema.length()-1) == 'e')
                            {
                                lexema += String.valueOf(ch);
                            }
                            else
                            {
                                lexema += String.valueOf(ch);
                                estado = EstadosAutomato.ERRO;
                                continue;
                            }
                        }
                        else if(Character.isDigit(ch))
                            lexema += String.valueOf(ch);
                        else
                        {
                            lexema += String.valueOf(ch);
                            estado = EstadosAutomato.ERRO;
                            continue;
                        }
                    }
                break;
                case IDENTIFICADOR:
                    ch = lerCaracter();
                    if(Delimitadores.isDelimiter(ch))
                    {
                        switch(lexema.toLowerCase())
                        {
                            case "file":
                                token = new Token(Tokens.FILE,lexema,numeroLinha);
                                break;
                            case "char":
                                token = new Token(Tokens.CHAR,lexema,numeroLinha);
                                break;
                            case "real":
                                token = new Token(Tokens.REAL,lexema,numeroLinha);
                                break;
                            case "integer":
                                token = new Token(Tokens.INT,lexema,numeroLinha);
                                break;
                            case "Boolean":
                                token = new Token(Tokens.BOOL,lexema,numeroLinha);
                                break;
                            case "text":
                                token = new Token(Tokens.TEXT,lexema,numeroLinha);
                                break;
                            case "if":
                                token = new Token(Tokens.IF,lexema,numeroLinha);
                                break;
                            case "else":
                                token = new Token(Tokens.ELSE, lexema, numeroLinha);
                                break;
                            case "while":
                                token = new Token(Tokens.WHILE, lexema, numeroLinha);
                                break;
                            case "for":
                                token = new Token(Tokens.FOR, lexema, numeroLinha);
                                break;
                            case "var":
                                token = new Token(Tokens.VAR, lexema, numeroLinha);
                                break;
                            case "begin":
                                token = new Token(Tokens.BEGIN,lexema,numeroLinha);
                                break;
                            case "nil":
                                token = new Token(Tokens.NIL,lexema,numeroLinha);
                                    break;
                            case "absolute":
                                token = new Token(Tokens.ABSOLUTE,lexema,numeroLinha);
                                break;
                            case "and":
                                token = new Token(Tokens.AND,lexema,numeroLinha);
                                break;
                            case "or":
                                token = new Token(Tokens.OR,lexema,numeroLinha);
                                break;
                            case "end":
                                token = new Token(Tokens.END,lexema,numeroLinha);
                                break;
                            case "set":
                                token = new Token(Tokens.SET,lexema,numeroLinha);
                                break;
                            case "not":
                                token =  new Token(Tokens.NOT,lexema,numeroLinha);
                                break;
                            case "shl":
                                token = new Token(Tokens.SHL,lexema,numeroLinha);
                                break;
                            case "array":
                                token = new Token(Tokens.ARRAY,lexema,numeroLinha);
                                break;
                            case "object":
                                token = new Token(Tokens.OBJECT,lexema,numeroLinha);
                                break;
                            case "shr":
                                token = new Token(Tokens.SHR,lexema,numeroLinha);
                                break;
                            case "asm":
                                token = new Token(Tokens.ASM,lexema,numeroLinha);
                                break;
                            case "of":
                                token = new Token(Tokens.OF,lexema,numeroLinha);
                                break;
                            case "until":
                                token = new Token(Tokens.UNTIL,lexema,numeroLinha);
                                break;
                            case "const":
                                token = new Token(Tokens.CONST,lexema,numeroLinha);
                                break;
                            case "on":
                                token = new Token(Tokens.ON,lexema,numeroLinha);
                                break;
                            case "then":
                                token = new Token(Tokens.THEN,lexema,numeroLinha);
                                break;
                            case "break":
                                token = new Token(Tokens.CONST,lexema,numeroLinha);
                                break;
                            case "goto":
                                token = new Token(Tokens.GOTO,lexema,numeroLinha);
                                break;
                            case "operator":
                                token = new Token(Tokens.OPERATOR,lexema,numeroLinha);
                                break;
                            case "to":
                                token = new Token(Tokens.TO,lexema,numeroLinha);
                                break;
                            case "case":
                                token = new Token(Tokens.CASE,lexema,numeroLinha);
                                break;
                            case "type":
                                token = new Token(Tokens.TYPE,lexema,numeroLinha);
                                break;
                            case "implementation":
                                token = new Token(Tokens.IMPLEMENTATION,lexema,numeroLinha);
                                break;
                            case "otherwise":
                                token = new Token(Tokens.OTHERWISE,lexema,numeroLinha);
                                break;
                            case "unit":
                                token = new Token(Tokens.UNIT,lexema,numeroLinha);
                                break;
                            case "constructor":
                                token = new Token(Tokens.CONSTRUCTOR,lexema,numeroLinha);
                                break;
                            case "in":
                                token = new Token(Tokens.IN,lexema,numeroLinha);
                                break;
                            case "procedure":
                                token = new Token(Tokens.PROCEDURE,lexema,numeroLinha);
                                break;
                            case "inherited":
                                token = new Token(Tokens.INHERITED,lexema,numeroLinha);
                                break;
                            case "program":
                                token = new Token(Tokens.PROGRAM,lexema,numeroLinha);
                                break;
                            case "uses":
                                token = new Token(Tokens.USES,lexema,numeroLinha);
                                break;
                            case "destructor":
                                token = new Token(Tokens.DESTRUCTOR,lexema,numeroLinha);
                                break;
                            case "inline":
                                token = new Token(Tokens.INLINE,lexema,numeroLinha);
                                break;
                            case "record":
                                token = new Token(Tokens.RECORD,lexema,numeroLinha);
                                break;
                            case "div":
                                token = new Token(Tokens.DIV,lexema,numeroLinha);
                                break;
                            case "interface":
                                token = new Token(Tokens.INTERFACE,lexema,numeroLinha);
                                break;
                            case "reintroduce":
                                token = new Token(Tokens.REINTRODUCE,lexema,numeroLinha);
                                break;
                            case "do":
                                token = new Token(Tokens.DO,lexema,numeroLinha);
                                break;
                            case "label":
                                token = new Token(Tokens.LABEL,lexema,numeroLinha);
                                break;
                            case "repeat":
                                token = new Token(Tokens.REPEAT,lexema,numeroLinha);
                                break;
                            case "with":
                                token = new Token(Tokens.WITH,lexema,numeroLinha);
                                break;
                            case "downto":
                                token = new Token(Tokens.DOWNTO,lexema,numeroLinha);
                                break;
                            case "mod":
                                token = new Token(Tokens.MOD,lexema,numeroLinha);
                                break;
                            case "self":
                                token = new Token(Tokens.SELF,lexema,numeroLinha);
                                break;
                            case "xor":
                                token = new Token(Tokens.XOR,lexema,numeroLinha);
                                break;
                            case "as":
                                token = new Token(Tokens.AS,lexema,numeroLinha);
                                break;
                            case "class":
                                token = new Token(Tokens.CLASS,lexema,numeroLinha);
                                break;
                            case "except":
                                token = new Token(Tokens.EXCEPT,lexema,numeroLinha);
                                break;
                            case "exports":
                                token = new Token(Tokens.EXPORTS,lexema,numeroLinha);
                                break;
                            case "finalization":
                                token = new Token(Tokens.FINALIZATION,lexema,numeroLinha);
                                break;
                            case "finally":
                                token = new Token(Tokens.FINALLY,lexema,numeroLinha);
                                break;
                            case "initialization":
                                token = new Token(Tokens.INITIALIZATION,lexema,numeroLinha);
                                break;
                            case "is":
                                token = new Token(Tokens.IS,lexema,numeroLinha);
                                break;
                            case "library":
                                token = new Token(Tokens.LIBRARY,lexema,numeroLinha);
                                break;
                            case "out":
                                token = new Token(Tokens.OUT,lexema,numeroLinha);
                                break;
                            case "raise":
                                token = new Token(Tokens.RAISE,lexema,numeroLinha);
                                break;
                            case "threadvar":
                                token = new Token(Tokens.THREADVAR,lexema,numeroLinha);
                                break;
                            case "try":
                                token = new Token(Tokens.TRY,lexema,numeroLinha);
                                break;
                            case "dispose":
                                token = new Token(Tokens.DISPOSE,lexema,numeroLinha);
                                break;
                            case "false":
                                token = new Token(Tokens.FALSE,lexema,numeroLinha);
                                break;
                            case "true":
                                token = new Token(Tokens.TRUE,lexema,numeroLinha);
                                break;
                            case "exit":
                                token = new Token(Tokens.EXIT,lexema,numeroLinha);
                                break;
                            case "new":
                                token = new Token(Tokens.NEW,lexema,numeroLinha);
                                break;
                            case "function":
                                token = new Token(Tokens.FUNCTION,lexema,numeroLinha);
                                break;
                            default:
                                token = new Token(Tokens.ID, lexema, numeroLinha);
                                break;

                        }
                        posicaoLinha--;
                    }
                    else
                    {
                        if(Character.isLetterOrDigit(ch) || ch == '_')
                            lexema += String.valueOf(ch);
                        else
                        {
                            estado = EstadosAutomato.ERRO;
                            lexema += String.valueOf(ch);
                            continue;
                        }
                    }
                break;
                case STRING:
                        ch = lerCaracter();
                        if((ch == '\'' && lexema.charAt(lexema.length()-1) != '{')
                          || (ch == '\'' && lexema.charAt(lexema.length()-1) == '{' && lexema.charAt(lexema.length()-2) == '{'))
                        {
                            lexema += String.valueOf(ch);
                            token = new Token(Tokens.STRING, lexema, numeroLinha);
                        }
                        else
                        {
                            if(ch == '\n')
                            {
                                estado = EstadosAutomato.ERRO;
                                continue;
                            }
                            else
                            {
                                lexema += String.valueOf(ch);
                            }
                        }
                        break;
                    case ERRO:
                    ch = lerCaracter();
                    if(Delimitadores.isDelimiter(ch))
                    {
                        token = new Token(Tokens.ERRO, lexema, numeroLinha);
                        posicaoLinha--;
                    }
                    else
                        lexema += String.valueOf(ch);
                        break;
                    case COMENTARIO:

                        ch = lerCaracter();
                       lexema+=String.valueOf(ch);

                        switch(lexema)
                        {
                            case "(*":
                                while(true){
                                ch = lerCaracter();
                                lexema+=String.valueOf(ch);
                                if(lexema.length()>=2){

                                    if("*)".equals(lexema.substring(lexema.length()-2,lexema.length())))
                                    {
                                        estado=EstadosAutomato.NAO_ALFANUMERICO;
                                        //getNewLine();
                                        break;
                                    }

                                }
                                }
                                break;
                                case "/*":
                                while(true){
                                ch = lerCaracter();
                                lexema+=String.valueOf(ch);
                                if(lexema.length()>=2){

                                    if("*/".equals(lexema.substring(lexema.length()-2,lexema.length())))
                                    {
                                        estado=EstadosAutomato.NAO_ALFANUMERICO;
                                        //getNewLine();
                                        break;
                                    }

                                }
                                }
                                break;




                        }
                        break;





                }

        }

       return token;
    }
}
