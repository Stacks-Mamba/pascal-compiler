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
public class Terminal extends Symbol implements Derivable  {
    
    
    
    private Tokens token;
    public final static String EMPTY_SYMBOL = "E";  
    
    public Terminal(String descrip,Tokens token){
        super(descrip);
        this.token = token;
    }
    
    @Override
    public int checkSymbol(Token t){
        if(t.getToken() == this.token || this.descrip.equals(EMPTY_SYMBOL)){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public Tokens getToken(){
        return token;
    }
    
    @Override
    public int verify(Token t){
        return checkSymbol(t);
    }
    
}
