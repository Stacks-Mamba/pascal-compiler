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
        //Introduzir os tipos padrão na tabela de símbolos
        this.addEntry(new TypeSymbol("INTEGER".toLowerCase()));
        this.addEntry(new TypeSymbol("REAL".toLowerCase()));
        this.addEntry(new TypeSymbol("CHAR".toLowerCase()));
        this.addEntry(new TypeSymbol("TEXT".toLowerCase()));
        this.addEntry(new TypeSymbol("WRITELN".toLowerCase()));
        this.addEntry(new TypeSymbol("READLN".toLowerCase()));
    }


    public void addEntry(Symbol symbol){
        symbols.put(symbol.getName(),symbol);
    }

    public Symbol lookup(String symbol){
        return symbols.get(symbol);
    }

    public void printTable(){
        System.out.println("\n\n\n-----------Tabela de Símbolos------------");
        for(String s:symbols.keySet()){
            System.out.println(symbols.get(s));
        }
    }
}
