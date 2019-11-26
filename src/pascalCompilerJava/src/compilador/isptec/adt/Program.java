package compilador.isptec.adt;

import compilador.isptec.semantico.SymbolTable;

public class Program implements AST {
    private String id;
    private AST block;

    public Program(String id, AST block) {
        this.id = id;
        this.block = block;
    }

    @Override
    public void showNode(){
        block.showNode();
    }

    @Override
    public void visit(SymbolTable table) {
    }
}
