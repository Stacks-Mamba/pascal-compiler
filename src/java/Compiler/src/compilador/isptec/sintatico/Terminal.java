/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;
import compilador.isptec.lexico.*;
import java.util.*;
/**
 *
 * @author stacks
 */
public class Terminal extends Symbol implements Parseable  {
    
    
    
    private Tokens token;
    public final static String EMPTY_SYMBOL = "E";  
    
    public Terminal(String descrip,Tokens token){
        super(descrip);
        this.token = token;
    }
    
    public static boolean containsToken(ArrayList<Terminal> list,Token t){
        for(Terminal terminal:list){
            if(terminal.matchToken(t)){
                return true;
            }
        }
        return false;
    }
    
    public boolean matchToken(Token t){
        return t.getToken() == this.token;
    }
    
    public Tokens getToken(){
        return token;
    }
    
    
    @Override
    public void parse(){
        //Verificar se esse símbolo
        if(this.descrip.equals(EMPTY_SYMBOL)){
            return;
        }
        else if(this.matchToken(Parser.lookahead)){
             Parser.consume(this.token,this);
        }
        else{
           Parser.error(this.getToken(),this,Parser.EXPECTED_ERROR);
        }
    }
    
}
