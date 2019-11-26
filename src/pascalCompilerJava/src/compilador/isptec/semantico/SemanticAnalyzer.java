package compilador.isptec.semantico;

import compilador.isptec.adt.*;
import compilador.isptec.sintatico.Error;

import java.util.ArrayList;

public class SemanticAnalyzer {

    public static SemanticAnalyzer analyzer = null;
    private SymbolTable symbolTable;
    private ArrayList<Error> errors;

    private SemanticAnalyzer() {
        errors = new ArrayList<>();
        this.symbolTable = new SymbolTable();
    }

    public static SemanticAnalyzer getInstance(){
        if(analyzer==null){
            analyzer = new SemanticAnalyzer();
        }
        return analyzer;
    }

    public void reportError(Error e){
        errors.add(e);
    }

    public void analyze(AST syntaxTree){
        //Método que vai visitar cada nó na ast
        syntaxTree.visit(symbolTable);
        symbolTable.printTable();
        //Mostrar erros encontrados
        for(Error e:errors){
            e.throwError();
        }
    }

}
