package compilador.isptec.adt;

import compilador.isptec.semantico.SymbolTable;

public class NullStatement implements AST {

    @Override
    public void showNode(){
        System.out.println("Null Statement");
    }

    @Override
    public void visit(SymbolTable table) {

    }
}
