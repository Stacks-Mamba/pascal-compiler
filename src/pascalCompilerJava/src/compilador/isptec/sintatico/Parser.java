package compilador.isptec.sintatico;
import compilador.isptec.lexico.Analex;
import compilador.isptec.lexico.Tokens;
import compilador.isptec.lexico.Token;
import java.io.IOException;

/**
 *
 * @author hairt
 */
public class Parser {
    public static Token lookahead;
    private static Analex lexer;

    public static final int EXPECTED_ERROR = 1; //Erro quando só tem uma alternativa
    public static final int UNKNOWN_ERROR = 2; // Erro para várias alternativas

    private static void initParser(String arquivo) throws IOException
    {
        lexer = new Analex();
        lexer.abreArquivo(arquivo);
        lookahead = lexer.getToken();
    }


    //Error Handling method
    public static void error(Tokens expected,int type){
      switch(type){
        case 1:
            System.err.println("Erro na linha "+lookahead.getLinha());
            System.err.println("Linha "+lookahead.getLinha()+": Era esperado o token " + expected + " porém foi recebido "+ lookahead.getToken()+".");
            System.exit(1);
            break;
        case 2:
            System.err.println(String.format("Símbolo inesperado:%s. Linha:%d",lookahead.getLexema(),lookahead.getLinha()));
            System.exit(1);
            break;
      }
    }



    //Function that advances the input
    public static void consume(Tokens t)
    {
      if(lookahead.getToken()!=t){
       Error e = new Error(String.format("Era esperado %s porém foi recebido %s",t,lookahead.getToken()),lookahead.getLinha());
       e.throwError();
      }
      else{
          System.out.println("Parsed token: "+lookahead);          
          //Get next input symbol
          lookahead = lexer.getToken();
      }
      
    }

    public static void parse(String file) throws IOException
    {
        //Initialize parser
        initParser(file);
        Grammar.program();
        //Comecar a execucao da análise léxica
        System.out.println("Compilacao Terminada com sucesso");
    }
    

    
    public static void main(String[] args) throws IOException {
       Parser.parse("testSrc/source.txt");
    }

}
