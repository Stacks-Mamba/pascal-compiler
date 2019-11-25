package compilador.isptec.semantico;

import compilador.isptec.semantico.Symbol;

import java.util.HashMap;

public class SymbolTable {

    private HashMap<String,Symbol> symbols;

    public SymbolTable(){
        symbols = new HashMap<>();
        initializeTable();
    }

    private void initializeTable(){
        //Introduzir símbolos padrão na table
        this.addEntry(new TypeSymbol("INTEGER"));
        this.addEntry(new TypeSymbol("REAL"));
        this.addEntry(new TypeSymbol("CHAR"));
        this.addEntry(new TypeSymbol("TEXT"));
    }


    public void addEntry(Symbol symbol){
        symbols.put(symbol.getName(),symbol);
    }

    public void lookup(String symbol){
        symbols.get(symbol);
    }
}
