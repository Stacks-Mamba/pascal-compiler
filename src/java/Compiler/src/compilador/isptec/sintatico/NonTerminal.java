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
public class NonTerminal extends Symbol implements Derivable{
    
    private final ArrayList<Derivation> derivations;
    
    public NonTerminal(String descrip) {
        super(descrip);
        derivations = new ArrayList<>();
    }
    
    public void addDerivation(Derivation d){
        this.derivations.add(d);
    }
    
    public void addDerivation(Derivation...derivations){
        this.derivations.addAll(Arrays.asList(derivations));
    }
    
    @Override
    public int checkSymbol(Token t){
        int c=0;
        for(Derivation d:derivations){
            if(d.checkDerivation(t)){
                return c;
            }
            c++;
        }
        return -1;
    }
    
    public Derivation getDerivation(int index){
        return derivations.get(index);
    }
    
     public ArrayList<Derivation> getDerivation(){
        return derivations;
    }
    
    
    @Override
    public int verify(Token t){
        return checkSymbol(t);
    }
    
    
    
}
