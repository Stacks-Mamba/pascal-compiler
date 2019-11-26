package compilador.isptec.adt;

import compilador.isptec.lexico.Token;
import compilador.isptec.semantico.SemanticAnalyzer;
import compilador.isptec.semantico.SymbolTable;
import compilador.isptec.semantico.VariableSymbol;
import compilador.isptec.sintatico.Error;

public class Reference implements AST{

    private Variable variable;

    public Reference(Variable variable){
        this.variable = variable;
    }


    @Override
    public void showNode(){
        this.variable.showNode();
    }

    @Override
    public void visit(SymbolTable table) {
        Token var =  variable.getToken();
        if(table.lookup(var.getLexema().toLowerCase())==null){
            Error e = new Error(String.format("O identificador %s não foi declarado.",var.getLexema()),var.getLinha());
            SemanticAnalyzer.getInstance().reportError(e);
        }
    }


}
