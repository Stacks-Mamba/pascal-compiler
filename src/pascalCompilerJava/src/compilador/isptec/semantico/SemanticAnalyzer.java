package compilador.isptec.semantico;

import compilador.isptec.adt.*;

public class SemanticAnalyzer {

    private AST syntaxTree;
    private SymbolTable symbolTable;

    public SemanticAnalyzer(AST syntaxTree,SymbolTable symbolTable) {
        this.syntaxTree = syntaxTree;
        this.symbolTable = symbolTable;

    }

    public void analyze(){

    }
}
