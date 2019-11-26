/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.main;
import compilador.isptec.adt.AST;
import compilador.isptec.lexico.*;
import compilador.isptec.semantico.SemanticAnalyzer;
import compilador.isptec.sintatico.Parser;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hairt
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //Pedir o ficheiro a ser compilado
        System.out.println("Digite o caminho para o ficheiro a ser compilado");
        System.out.print("> ");
        String filename = in.nextLine();
        System.out.println("\n\n\n\n\n");
        File file = new File(filename);
        try{
            System.out.println("Iniciando compilacão");
            //Parse the file
            AST program = Parser.parse(filename);
            //Se análise sintática terminar sem erros, iniciar a semântica
            if (program != null){
                SemanticAnalyzer sem = SemanticAnalyzer.getInstance();
                boolean result = sem.analyze(program);
                if(result){
                    System.out.println("Compilacão terminada com sucesso");
                }
                else{
                    sem.showErrors();
                    System.err.println("Compilacão terminada com erros");
                }
            }
            else{
                Parser.showErrors();
                System.err.println("Compilacão terminada com erros");
            }

        }
        catch(IOException e){
            System.out.println("Ocorreu um erro ao abrir o ficheiro\n");
            System.out.println("\n\n\n\n\n");
        }
    }
    
}
