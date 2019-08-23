/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.main;
import compilador.isptec.lexico.*;
import java.io.IOException;

/**
 *
 * @author hairt
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Analex analisador = new Analex();
        try
        {
            analisador.abreArquivo("teste1.txt");

            Token token;

            token = analisador.getToken();
         
            while(token.getToken() != Tokens.EOF)
            {
                System.out.println(token);
                token = analisador.getToken();
            }
            System.out.println(token);

        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
