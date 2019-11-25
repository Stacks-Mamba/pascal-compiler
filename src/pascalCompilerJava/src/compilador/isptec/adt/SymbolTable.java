package compilador.isptec.adt;

import compilador.isptec.sintatico.Symbol;

import java.util.HashMap;

public class SymbolTable {

    private HashMap<String,Symbol> symbols;

    public SymbolTable(){
        symbols = new HashMap<>();
    }


    public void addEntry(String key,Symbol value){
        symbols.put(key,value);
    }

    public void lookup(String symbol){
        symbols.get(symbol);
    }
}
