package compilador.isptec.adt;

import compilador.isptec.lexico.Token;
import compilador.isptec.semantico.SymbolTable;

public class Variable implements AST {
    private Token token;
    private String name;

    public Variable(Token token) {
        this.token = token;
        this.name = token.getLexema();
    }

    @Override
    public void showNode(){
        System.out.println("Variable/Reference");
        System.out.println(token);
    }

    public Token getToken() {
        return token;
    }

    @Override
    public void visit(SymbolTable table) {

    }
}
