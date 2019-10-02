/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;

import compilador.isptec.lexico.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author stacks
 */
public class Derivation {
    
    private ArrayList<Derivable> symbols;
    
    public Derivation(){
        this.symbols = new ArrayList<>();
    }
    
    public void addSymbol(Derivable symbol){
        symbols.add(symbol);
    }
    
    public boolean checkDerivation(Token t){
        if(symbols.get(0).getClass() == Terminal.class || symbols.get(0).getClass() == Sequence.class){
            return (symbols.get(0).verify(t) > 0);
        }
        else{
            return (symbols.get(0).verify(t) > -1);
        }
    }
    
    
    //Método para verificar o lado direito das regras de producao
    public void derive(){
        //Para cada símbolo na regra
        for(Derivable s:symbols){
            
            //Se for um terminal
            if(s.getClass() == Terminal.class){
                Terminal aux = (Terminal) s;
                if(aux.checkSymbol(Parser.lookahead)==1){
                    Parser.consume();
                }
                else{
                    Parser.error(aux.getToken(),Parser.EXPECTED_ERROR);
                }
            }
            
            //Se for não terminal
            else if(s.getClass() == NonTerminal.class){
                NonTerminal aux = (NonTerminal) s;
                //Get the index of the correct derivation
                int index = aux.checkSymbol(Parser.lookahead);
                
                if(index>=0){
                    //Aqui é a chamada recursiva que garante a derivacao
                    aux.getDerivation(index).derive();
                }
                else{
                    Parser.error(Parser.lookahead.getToken(),Parser.EXPECTED_ERROR);
                }
            }
            else{
                
                Sequence aux = (Sequence) s;
                if(aux.verify(Parser.lookahead)==1){
                    while(aux.verify(Parser.lookahead)==1){
                        aux.derive();
                    }
                }  
            }
        }
    }
}
