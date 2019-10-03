package compilador.isptec.sintatico;

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
public interface Derivable {
    
    public abstract int verify(Token t);
}
