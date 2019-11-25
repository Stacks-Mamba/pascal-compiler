package compilador.isptec.adt;

import compilador.isptec.lexico.Tokens;

public class VariableDeclaration implements AST {
    private Variable variable;
    private Tokens type;

    public VariableDeclaration(Variable variable, Tokens type) {
        this.variable = variable;
        this.type = type;
    }

    @Override
    public void visit(){
        System.out.println("Variable Declaration\n_______________");
        variable.visit();
        System.out.println(type);

    }
}
