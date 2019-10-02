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
public class Sequence extends Derivation implements Derivable {
    
    public Sequence(){
        super();
    }
    
    @Override
    public int verify(Token t){
        return (super.checkDerivation(t))?1:0;
    }
}
