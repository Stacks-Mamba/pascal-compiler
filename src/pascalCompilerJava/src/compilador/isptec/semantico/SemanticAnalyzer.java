package compilador.isptec.semantico;

import compilador.isptec.adt.*;

public class SemanticAnalyzer {

    private AST syntaxTree;
    private SymbolTable symbolTable;

    public SemanticAnalyzer(AST syntaxTree) {
        this.syntaxTree = syntaxTree;
        this.symbolTable = new SymbolTable();

    }

    public void analyze(){
        //Método que vai visitar cada nó na ast
        syntaxTree.visit(symbolTable);
        symbolTable.printTable();
    }
}
