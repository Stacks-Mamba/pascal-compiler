/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private void label(){
    if(lookahead.getToken().equals(Tokens.NUMINT))
    {
        
    }
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
