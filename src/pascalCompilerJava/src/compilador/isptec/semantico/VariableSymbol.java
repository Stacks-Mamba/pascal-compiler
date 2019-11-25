package compilador.isptec.semantico;


public class VariableSymbol extends Symbol {
    private TypeSymbol type;


    public VariableSymbol(String name,TypeSymbol type){
        super(name);
        this.type = type;
    }

    public VariableSymbol(String name) {
        super(name);
    }

    public TypeSymbol getType() {
        return type;
    }

    public void setType(TypeSymbol type) {
        this.type = type;
    }
}
