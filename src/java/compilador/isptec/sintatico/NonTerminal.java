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
public class NonTerminal extends Symbol{
    
    private final ArrayList<Derivation> derivations;
    
    public NonTerminal(String descrip) {
        super(descrip);
        derivations = new ArrayList<>();
    }
    
    
}
