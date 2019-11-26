package compilador.isptec.semantico;


public class VariableSymbol extends Symbol {
    private Symbol type;


    public VariableSymbol(String name,Symbol type){
        super(name);
        this.type = type;
    }

    public VariableSymbol(String name) {
        super(name);
    }

    public Symbol getType() {
        return type;
    }

    public void setType(Symbol type) {
        this.type = type;
    }
}
