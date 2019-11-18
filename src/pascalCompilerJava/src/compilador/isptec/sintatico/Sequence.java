package compilador.isptec.sintatico;

import java.util.ArrayList;
import compilador.isptec.lexico.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stacks
 */
public class Sequence extends RightSide implements Parseable {
    
    public Sequence(){
        super();
    }
    
    public Sequence(Parseable...ds){
        super(ds);
    }
    
    @Override
    public void parse(){
        Parseable symbol = this.getSymbols().get(0);
        ArrayList<Terminal> firstList = Parser.first(symbol);
        System.out.println("**First list********");
        for(Terminal t:firstList){
            System.out.println(t);
        }
        System.out.println("*****************");
        while(Terminal.containsToken(firstList,Parser.lookahead)){
            System.out.println("Entrei");
            for(Parseable p:this.getSymbols()){
                p.parse();
            }
        }
    }
    
    @Override
    public String toString(){
        return this.getSymbols().get(0).toString();
    }
}
