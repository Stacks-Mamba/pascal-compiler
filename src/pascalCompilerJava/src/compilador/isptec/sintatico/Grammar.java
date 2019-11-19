/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;
import compilador.isptec.lexico.*;
import java.io.*;
/**
 *
 * @author stacks
 */

/*Classe que contém todas as producoes da nossa gramática*/

public class Grammar {

    public static void program(){
        programHeading();
        block();
        Parser.consume(Tokens.PONTO);
    }

    public static void programHeading(){
        Parser.consume(Tokens.PROGRAM);
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.ABREPAR);
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken()==Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.FECHAPAR);
        Parser.consume(Tokens.PONTOVIRGULA);
    }

    public static void block(){
        labelDeclPart();
        /*constantDefPart();
        typeDefPart();
        varDeclPart();
        procAndFuncDeclPart();
        statementPart();*/
    }

    public static void labelDeclPart(){
        if(Parser.lookahead.getToken()==Tokens.LABEL){
            Parser.consume(Tokens.LABEL);
            Parser.consume(Tokens.NUMINT);
            while(Parser.lookahead.getToken()==Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                Parser.consume(Tokens.NUMINT);
            }
            Parser.consume(Tokens.PONTOVIRGULA);
        }
    }

    
}
