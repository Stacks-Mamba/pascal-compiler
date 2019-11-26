package compilador.isptec.adt;

import compilador.isptec.semantico.SymbolTable;

public class NullType extends Type{



    @Override
    public void showNode(){
        System.out.println("Null node");
    }


    @Override
    public void visit(SymbolTable table) {
    }
}
