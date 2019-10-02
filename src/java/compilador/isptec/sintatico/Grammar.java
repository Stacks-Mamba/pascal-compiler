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
public class Grammar {
    
    //Program Heading production
    public static NonTerminal PH = new NonTerminal("<Program Heading>");
    public static Terminal id = new Terminal("ID",Tokens.ID);
    public static Terminal virgula = new Terminal(",",Tokens.VIRGULA);
    public static Terminal program = new Terminal("program",Tokens.PROGRAM);
    public static Terminal parl = new Terminal("(",Tokens.ABREPAR);
    public static Terminal parr = new Terminal(")",Tokens.FECHAPAR);
    public static Terminal pv = new Terminal(";",Tokens.PONTOVIRGULA);
    
    
    
    
    public static void initPH(){
        Derivation d = new Derivation();
        d.addSymbol(program);
        d.addSymbol(id);
        d.addSymbol(parl);
        d.addSymbol(id);
        Sequence s = new Sequence();
        s.addSymbol(virgula);
        s.addSymbol(id);
        d.addSymbol(s);
        d.addSymbol(parr);
        d.addSymbol(pv);
        PH.addDerivation(d);
    }
}
