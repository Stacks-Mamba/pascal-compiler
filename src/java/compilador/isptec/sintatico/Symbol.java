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

/*Classe que representa um símbolo terminal ou não terminal*/

public abstract class Symbol implements Derivable {
    
    protected final String descrip;
    
    public Symbol(String descrip){
        
        this.descrip = descrip;
    }
    
    public abstract int checkSymbol(Token t);
    
}
