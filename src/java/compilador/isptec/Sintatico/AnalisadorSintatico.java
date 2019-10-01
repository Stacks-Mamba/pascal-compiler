package compilador.isptec.sintatico;
import compilador.isptec.lexico.Analex;
import compilador.isptec.lexico.Tokens;
import compilador.isptec.lexico.Token;
import java.io.IOException;
/**
 *
 * @author hairt
 */
public class AnalisadorSintatico {
    private Token lookahead;
    private Analex analisadorLexico;
    public AnalisadorSintatico(String arquivo) throws IOException
    {
        analisadorLexico = new Analex();
        analisadorLexico.abreArquivo(arquivo);
    }
    public void parser()
    {
        lookahead = analisadorLexico.getToken();
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
            consume(Tokens.NUMINT);
        }
    }
    private void fieldIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void controlVariable()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void functionIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void procedureIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void variableIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void constantIdentifier()
    {
        if(lookahead.getToken().equals(Tokens.ID))
        {
            consume(Tokens.ID);
        }
    }
    private void addingOperator()
    {
     if(lookahead.getToken().equals(Tokens.MAIS))
         consume(Tokens.MAIS);
     if(lookahead.getToken().equals(Tokens.MENOS))
         consume(Tokens.MENOS);
     if(lookahead.getToken().equals(Tokens.OR))
         consume(Tokens.OR);
    }
    private void relationalOperator()
    {
     if(lookahead.getToken().equals(Tokens.IGUAL))
         consume(Tokens.IGUAL);
     if(lookahead.getToken().equals(Tokens.DIFERENTE))
         consume(Tokens.DIFERENTE);
     if(lookahead.getToken().equals(Tokens.MENOR))
         consume(Tokens.MENOR);
     if(lookahead.getToken().equals(Tokens.MENORIGUAL))
         consume(Tokens.MENORIGUAL);
     if(lookahead.getToken().equals(Tokens.MAIORIGUAL))
         consume(Tokens.MAIORIGUAL);
     if(lookahead.getToken().equals(Tokens.MAIOR))
         consume(Tokens.MAIOR);
     if(lookahead.getToken().equals(Tokens.IN))
         consume(Tokens.IN);
    }
    private void multiplyingOperator()
    {
     if(lookahead.getToken().equals(Tokens.VEZES))
         consume(Tokens.VEZES);
     if(lookahead.getToken().equals(Tokens.DIVISAO))
         consume(Tokens.DIVISAO);
     if(lookahead.getToken().equals(Tokens.DIV))
         consume(Tokens.DIV);
     if(lookahead.getToken().equals(Tokens.MOD))
         consume(Tokens.MOD);
     if(lookahead.getToken().equals(Tokens.AND))
         consume(Tokens.AND);
     if(lookahead.getToken().equals(Tokens.MAIOR))
         consume(Tokens.MAIOR);
    }
    
    private void sign()
    {
     if(lookahead.getToken().equals(Tokens.MAIS))
         consume(Tokens.MAIS);
     if(lookahead.getToken().equals(Tokens.MENOS))
         consume(Tokens.MENOS);
    }
    private void consume(Tokens token)
    {
        if(lookahead.getToken() == token)
        {
            lookahead = analisadorLexico.getToken();
        }
        else
        {
            System.err.println("Erro na linha "+lookahead.getLinha());
            System.err.println("Era esperado o token " + token + " porém foi recebido "+ lookahead.getToken()+".");
            System.exit(1);
        }
    }
}