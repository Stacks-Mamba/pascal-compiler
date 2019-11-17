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
public class NonTerminal extends Symbol implements Parseable{
    
    private final ArrayList<RightSide> derivations;
    
    public NonTerminal(String descrip) {
        super(descrip);
        derivations = new ArrayList<>();
    }
    
    public void addRightSide(RightSide d){
        this.derivations.add(d);
    }
    
    public void addRightSide(RightSide...derivations){
        this.derivations.addAll(Arrays.asList(derivations));
    }
    
    public RightSide getRightSide(int index){
        return derivations.get(index);
    }
    
     public ArrayList<RightSide> getDerivation(){
        return derivations;
    }
     
    @Override
    public void parse(){
        //System.out.println("Parsing: "+this);
        //Check the right side and start deriving 
        RightSide production = null;
        for(RightSide rs:derivations){
            if(Terminal.containsToken(rs.getFirst(),Parser.lookahead)){
                production = rs;
                break;
            }
        }
        if(production == null){
            for(RightSide rs:derivations){
                if((rs.getFirst().contains(Grammar.empty) && Terminal.containsToken(rs.getSecond(),Parser.lookahead))||
                    (rs.getFirst().contains(Grammar.empty) && rs.getSecond().contains(Grammar.empty))){
                    production = rs;
                    break;
                }
            }
        }
        if(production !=null){
            System.out.println("Choosen production: "+production.getSymbols().get(0));
            for(Parseable p:production.getSymbols()){
                p.parse();
            }
        }
    }
    
    
   
    
    
    
}
