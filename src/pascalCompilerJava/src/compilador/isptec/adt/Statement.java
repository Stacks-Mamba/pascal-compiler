package compilador.isptec.adt;

import compilador.isptec.semantico.SymbolTable;

import java.util.ArrayList;

public class Statement implements AST{
    private ArrayList<Reference> refs;


    public Statement(ArrayList<Reference> refs) {
        this.refs = refs;
    }

    @Override
    public void showNode(){
        System.out.println("\n\nStatement\n____________");
        for(Reference ref:refs){
            ref.showNode();
        }
    }


    @Override
    public void visit(SymbolTable table) {
        for(Reference ref:refs){
            ref.visit(table);
        }
    }
}
