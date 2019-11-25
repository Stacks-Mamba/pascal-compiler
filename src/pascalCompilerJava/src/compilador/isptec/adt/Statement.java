package compilador.isptec.adt;

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
}
