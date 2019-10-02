/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;

import java.util.ArrayList;

/**
 *
 * @author stacks
 */
public class Derivation {
    
    private ArrayList<Symbol> symbols;
    
    public Derivation(){
        this.symbols = new ArrayList<>();
    }
    
    public void addSymbol(Symbol symbol){
        symbols.add(symbol);
    }
}
