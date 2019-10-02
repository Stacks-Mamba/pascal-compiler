package compilador.isptec.sintatico;
import compilador.isptec.lexico.Analex;
import compilador.isptec.lexico.Tokens;
import compilador.isptec.lexico.Token;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author hairt
 */
public class Parser {
    private Token lookahead;
    private Analex lexer;

    private static final int EXPECTED_ERROR = 1; //Erro quando só tem uma alternativa
    private static final int UNKNOWN_ERROR = 2; // Erro para várias alternativas

    public Parser(String arquivo) throws IOException
    {
        lexer = new Analex();
        lexer.abreArquivo(arquivo);
    }
    //Error Handling method
    private void error(Tokens expected,int type){
      switch(type){
        case 1:
            System.err.println("Erro na linha "+lookahead.getLinha());
            System.err.println("Era esperado o token " + expected + " porém foi recebido "+ lookahead.getToken()+".");
            System.exit(1);
            break;
        case 2:
            System.err.println(String.format("Símbolo inesperado:%s. Linha:%d",lookahead.getLexema(),lookahead.getLinha()));
            break;
      }
    }
    private void gotoStatement()
    {
        if(lookahead.getToken().equals(Tokens.GOTO))
        {
            consume();
            label(); 
        }
        else
            error(Tokens.GOTO,EXPECTED_ERROR);
    }


    //Function that advances the input
    private void consume()
    {
      //Get next input symbol
      lookahead = lexer.getToken();
    }

    public void parser()
    {
        lookahead = lexer.getToken();
        program();
        consume();
        System.out.println("Compilação realizada com sucesso.");
    }
    private void program()
    {
     
    }
    private void unsignedNumber(){
        switch (lookahead.getToken()) {
            case NUMINT:
                consume();
                break;
            case NUMREAL:
                consume();
                break;
            default:
                error(Tokens.NUMREAL,UNKNOWN_ERROR);
                break;
        }
    }
    private void empty()
    {
         consume();    
    }
    private void labelDeclarationpart()
        {
            if(lookahead.getToken().equals(Tokens.LABEL))
            {
            consume();
            label();
            while(lookahead.getToken().equals(Tokens.VIRGULA))
            {
                consume();
                label();
            }
            if(lookahead.getToken().equals(Tokens.PONTOVIRGULA))
                    consume();
                else
                    error(Tokens.PONTOVIRGULA,EXPECTED_ERROR);
                
                
            }
            else
                empty();
        }
    private void constantdefpart()
        {
          //  if(lookahead.getToken().equals(Tokens.CONST))
        }
    private void constant()
        {
            /*if(lookahead.getToken().equals(Tokens.STRING))
                {
                    consume();
                }
                else if()*/
        }
    private void sign1()
        {

        }
    private void emptystatement()
        {
            empty();
        }
    private void label()
        {
            if(lookahead.getToken().equals(Tokens.NUMINT))
            {
                consume();
            }
            else
                error(Tokens.NUMINT,EXPECTED_ERROR);
        }
    private void Identifier()
        {
            if(lookahead.getToken().equals(Tokens.ID))
            {
                consume();
            }
            else
                error(Tokens.ID,EXPECTED_ERROR);
        }
    private void controlVariable()
        {
            if(lookahead.getToken().equals(Tokens.ID))
            {
                consume();
            }
            else
            error(Tokens.ID,EXPECTED_ERROR);
        }
    private void addingOperator()
        {
            switch (lookahead.getToken()) {
                case MAIS:
                    consume();
                    break;
                case MENOS:
                    consume();
                    break;
                case OR:
                    consume();
                    break;
                default:
                    error(Tokens.MAIS,UNKNOWN_ERROR);
                    break;
            }
        }

    private void relationalOperator()
        {
            switch (lookahead.getToken()) {
                case IGUAL:
                    consume();
                    break;
                case DIFERENTE:
                    consume();
                    break;
                case MENOR:
                    consume();
                    break;
                case MENORIGUAL:
                    consume();
                    break;
                case MAIORIGUAL:
                    consume();
                    break;
                case MAIOR:
                    consume();
                    break;
                case IN:
                    consume();
                    break;
                default:
                    error(Tokens.MAIS,UNKNOWN_ERROR);
                    break;
            }
        }

    private void multiplyingOperator()
        {
            switch (lookahead.getToken()) {
                case VEZES:
                    consume();
                    break;
                case DIVISAO:
                    consume();
                    break;
                case DIV:
                    consume();
                    break;
                case MOD:
                    consume();
                    break;
                case AND:
                    consume();
                    break;
                case MAIOR:
                    consume();
                    break;
                default:
                    error(Tokens.VEZES,UNKNOWN_ERROR);
                    break;
            }
        }
    private void entireVariable()
        {
            Identifier();
        }
    private void resultType(){
        Identifier();
    }
    private void sign()
    {
        switch (lookahead.getToken()) {
            case MAIS:
                consume();
                break;
            case MENOS:
                consume();
                break;
            default:
                error(Tokens.MAIS,UNKNOWN_ERROR);
                break;
        }
    }

}
