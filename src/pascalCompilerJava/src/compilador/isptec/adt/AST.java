package compilador.isptec.adt;

import compilador.isptec.semantico.SymbolTable;

public interface AST {

     void showNode();
     void visit(SymbolTable table);
}
