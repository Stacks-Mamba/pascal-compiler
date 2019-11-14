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
        Sequence aux = (Sequence) s;
        if(aux.verify(Parser.lookahead)==0){
            while(aux.verify(Parser.lookahead)==0){
                aux.derive();
            }
        }
        else{
            Parser.consume();
        }
    }
}
