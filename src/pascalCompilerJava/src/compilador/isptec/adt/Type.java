package compilador.isptec.adt;

import compilador.isptec.lexico.Tokens;

public abstract class Type implements AST {
    private Tokens type;

    public Type(Tokens type) {
        this.type = type;
    }

    public Type(){}

    public Tokens getType() {
        return type;
    }
}
