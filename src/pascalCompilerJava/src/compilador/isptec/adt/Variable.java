package compilador.isptec.adt;

import compilador.isptec.lexico.Token;

public class Variable implements AST {
    private Token token;
    private String name;

    public Variable(Token token) {
        this.token = token;
        this.name = token.getLexema();
    }

    @Override
    public void showNode(){
        System.out.println(token);
    }
}
