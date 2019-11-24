package compilador.isptec.sintatico;
import compilador.isptec.lexico.Analex;
import compilador.isptec.lexico.Tokens;
import compilador.isptec.lexico.Token;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hairt
 */
public class Parser {
    public static Token lookahead;
    private static Analex lexer;
    private static boolean recoveryState = false;
    private static final ArrayList<Error> errors =new ArrayList<>();

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
      if(!recoveryState) {
          if (lookahead.getToken() != t) {
              Error e = new Error(String.format("Era esperado %s porém foi recebido %s", t, lookahead.getToken()), lookahead.getLinha());
              errors.add(e);
              recoveryState = true;
              /* Using the panic method to find a synchronizing token*/
              panic();

          } else {
              System.out.println("Parsed token: " + lookahead);
              //Get next input symbol
              lookahead = lexer.getToken();
          }
      }
      else{
          if(lookahead.getToken() == t){
              lookahead = lexer.getToken();
              recoveryState = false;
          }
      }
    }

    private static void panic(){
        Tokens syncToken = lookahead.getToken();
        while (syncToken !=Tokens.PONTOVIRGULA && syncToken != Tokens.EOF &&
                syncToken != Tokens.END && syncToken != Tokens.PONTO ){
            lookahead = lexer.getToken();
            syncToken = lookahead.getToken();
            System.out.println(syncToken);
        }
        if(lookahead.getToken() == Tokens.EOF) {
            showErrors();
            System.exit(1);
        }
    }

    private static void showErrors(){
        System.err.printf("Erros: %d\n",errors.size());
        for(Error e : errors){
            e.throwError();
        }

    }

    public static void parse(String file) throws IOException {
        //Initialize parser
        initParser(file);
        //Comecar a execucao da análise léxica
        Grammar.program();
        if(errors.size()>0){
            showErrors();
            System.err.println("Compilacao Terminada com erros");
        }
        else{
            System.out.println("Compilacao Terminada com sucesso");
        }
    }
    

    
    public static void main(String[] args) throws IOException {
       Parser.parse("testSrc/source.txt");
    }

}
