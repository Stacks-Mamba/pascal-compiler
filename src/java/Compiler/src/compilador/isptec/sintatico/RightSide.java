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
public class RightSide {
    
    private ArrayList<Parseable> symbols;
    
    public RightSide(){
        this.symbols = new ArrayList<>();
    }
    
    public RightSide(Parseable...derivables){
        this.symbols = new ArrayList<>();
        symbols.addAll(Arrays.asList(derivables));
    }
    
    public void addSymbol(Parseable symbol){
        symbols.add(symbol);
    }
    
    public ArrayList<Terminal> getFirst(){
        return Parser.first(symbols.get(0));
    }
    

    public ArrayList<Parseable> getSymbols(){
        return symbols;
    }
    
    
}
