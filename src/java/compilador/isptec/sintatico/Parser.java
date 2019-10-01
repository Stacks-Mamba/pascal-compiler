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
    private void erro(Tokens expected,int type){
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



    //Function that advances the input
    private void consume()
    {

      lookahead = lexer.getToken();

    }

    public void parser()
    {
        lookahead = lexer.getToken();
        program();
        consume(Tokens.EOF);
        System.out.println("Compilação realizada com sucesso.");
    }
    private void program()
    {

    }
    private void empty()
    {

    }
    private void emptystatement(){
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
    private void fieldIdentifier()
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
    private void functionIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume();
        }
        else
          error(Tokens.ID,EXPECTED_ERROR);

    }
    private void procedureIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume();
        }
        else
            error(Tokens.ID,EXPECTED_ERROR);
    }
    private void variableIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume();
        }
        else
          error(Tokens.ID,EXPECTED_ERROR);
    }
    private void constantIdentifier(){
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume();
        }
        else
          error(Tokens.ID,EXPECTED_ERROR);
    }
    private void addingOperator(){
     if(lookahead.getToken().equals(Tokens.MAIS))
         consume();
     else if(lookahead.getToken().equals(Tokens.MENOS))
         consume();
     else if(lookahead.getToken().equals(Tokens.OR))
         consume();
      else
        error(Tokens.MAIS,UNKNOWN_ERROR);
    }

    private void relationalOperator()
    {
     if(lookahead.getToken().equals(Tokens.IGUAL))
         consume();
     else if(lookahead.getToken().equals(Tokens.DIFERENTE))
         consume();
     else if(lookahead.getToken().equals(Tokens.MENOR))
         consume();
     else if(lookahead.getToken().equals(Tokens.MENORIGUAL))
         consume();
     else if(lookahead.getToken().equals(Tokens.MAIORIGUAL))
         consume();
     else if(lookahead.getToken().equals(Tokens.MAIOR))
         consume();
     else if(lookahead.getToken().equals(Tokens.IN))
         consume();
      else
       error(Tokens.MAIS,UNKNOWN_ERROR);
    }

    private void multiplyingOperator()
    {
     if(lookahead.getToken().equals(Tokens.VEZES))
         consume();
     else if(lookahead.getToken().equals(Tokens.DIVISAO))
         consume();
     else if(lookahead.getToken().equals(Tokens.DIV))
         consume();
     else if(lookahead.getToken().equals(Tokens.MOD))
         consume();
     else if(lookahead.getToken().equals(Tokens.AND))
         consume();
     else if(lookahead.getToken().equals(Tokens.MAIOR))
         consume();
      else
        error(Tokens.VEZES,UNKNOWN_ERROR);
    }

    private void sign()
    {
     if(lookahead.getToken().equals(Tokens.MAIS))
         consume();
     else if(lookahead.getToken().equals(Tokens.MENOS))
         consume();
      else
       error(Tokens.MAIS,UNKNOWN_ERROR);
    }

}
