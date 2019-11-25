package compilador.isptec.nodes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Block extends AST {
    private AST variableDeclaration;
    private AST procedureDeclaration;
    private ArrayList<AST> statements;

    public Block(AST variableDeclaration, AST procedureDeclaration, ArrayList<AST> statements) {
        this.variableDeclaration = variableDeclaration;
        this.procedureDeclaration = procedureDeclaration;
        this.statements = statements;
    }
}
