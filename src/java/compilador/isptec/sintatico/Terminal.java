/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;
import compilador.isptec.lexico.*;
/**
 *
 * @author stacks
 */
public class Terminal extends Symbol {
    
    private Tokens token;
            
    public Terminal(String descrip,Tokens token){
        super(descrip);
        this.token = token;
    }
    
}
