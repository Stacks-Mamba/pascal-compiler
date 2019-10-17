/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;

import compilador.isptec.lexico.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author stacks
 */
public class Derivation {
    
    private ArrayList<Derivable> symbols;
    
    public Derivation(){
        this.symbols = new ArrayList<>();
    }
    
    public Derivation(Derivable...derivables){
        this.symbols = new ArrayList<>();
        symbols.addAll(Arrays.asList(derivables));
    }
    
    public void addSymbol(Derivable symbol){
        symbols.add(symbol);
    }
    
    public boolean checkDerivation(Token t){
        return (symbols.get(0).verify(t) > -1);
    }
    
    
    //Método para verificar o lado direito das regras de producao
    public void derive(){
        //Para cada símbolo na regra
        for(Derivable s:symbols){
            
            //Se for um terminal
            if(s.getClass() == Terminal.class){
                Terminal aux = (Terminal) s;
                if(aux.checkSymbol(Parser.lookahead)==0){
                    System.out.printf("A token matchou:%s\n",Parser.lookahead.getToken());
                    Parser.consume();
                }
                else{
                    Parser.error(aux.getToken(),aux,Parser.EXPECTED_ERROR);
                }
            }
            //Se for não terminal
            else if(s.getClass() == NonTerminal.class){
                NonTerminal aux = (NonTerminal) s;
                //Get the index of the correct derivation
                int index = aux.checkSymbol(Parser.lookahead);
                
                if(index>=0){
                    System.out.printf("Current non-terminal: %s\n",aux);
                    //Aqui é a chamada recursiva que garante a derivacao
                    aux.getDerivation(index).derive();
                    
                }
                else{
                    Parser.error(Parser.lookahead.getToken(),aux,Parser.EXPECTED_ERROR);
                }
            }
            else{
                
                Sequence aux = (Sequence) s;
                if(aux.verify(Parser.lookahead)==0){
                    while(aux.verify(Parser.lookahead)==0){
                        aux.derive();
                    }
                }
                else{
                    Parser.consume();
                } 
            }
        }
    }

    public ArrayList<Derivable> getSymbols()
    {
        return symbols;
    }
    
    
}
