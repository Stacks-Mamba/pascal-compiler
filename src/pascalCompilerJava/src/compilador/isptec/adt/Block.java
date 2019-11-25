package compilador.isptec.adt;

import java.util.ArrayList;

public class Block implements AST {
    private ArrayList<AST> variableDeclarations;
    private ArrayList<AST> procedureDeclarations;
    private ArrayList<AST> statements;


    public Block(ArrayList<AST> variableDeclarations, ArrayList<AST> procedureDeclarations, ArrayList<AST> statements) {
        this.variableDeclarations = variableDeclarations;
        this.procedureDeclarations = procedureDeclarations;
        this.statements = statements;
    }


    @Override
    public void showNode(){
        System.out.println("Block\n_______________");
        if(variableDeclarations != null) {
            for (AST node : variableDeclarations) {
                node.showNode();
            }
        }

        if(procedureDeclarations != null) {
            for (AST node : procedureDeclarations) {
                node.showNode();
            }
        }

        if(statements != null) {
            for (AST node : statements) {
                node.showNode();
            }
        }
    }
}
