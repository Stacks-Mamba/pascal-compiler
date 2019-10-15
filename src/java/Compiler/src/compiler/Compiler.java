/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import compilador.isptec.lexico.*;
import java.io.*;
/**
 *
 * @author Stenio Jacinto
 */
public class Compiler
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
        Analex lexer = new Analex("teste2.pas");
        Token t = lexer.getToken();
        while(t.getToken()!=Tokens.EOF){
            System.out.println(t);
            t = lexer.getToken();
        }
    }
    
}
