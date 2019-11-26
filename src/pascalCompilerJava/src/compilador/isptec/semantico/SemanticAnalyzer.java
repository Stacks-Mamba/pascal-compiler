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

    public void showErrors(){
        for(Error e:errors){
            e.throwError();
        }
    }

    //Retorna true se a análise foi realizada e não foram encontrados erros
    public boolean analyze(AST syntaxTree){
        //Método que vai visitar cada nó na ast
        syntaxTree.visit(symbolTable);
        if(errors.size()>0){
            return false;
        }
        return true;
    }

}
