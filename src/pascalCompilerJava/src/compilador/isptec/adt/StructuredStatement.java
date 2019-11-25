package compilador.isptec.adt;

import compilador.isptec.lexico.Tokens;

import java.util.ArrayList;

public class StructuredStatement implements AST {

    private Tokens Type;
    private ArrayList<AST> statements;

    public StructuredStatement(Tokens type, ArrayList<AST> statements) {
        Type = type;
        this.statements = statements;
    }

    public void setStatements(ArrayList<AST> statements){
        this.statements = statements;
    }

    @Override
    public void showNode(){
        System.out.println("Structured Statement");

        for(AST s:statements){
            s.showNode();
        }
    }
}
