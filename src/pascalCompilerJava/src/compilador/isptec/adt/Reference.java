package compilador.isptec.adt;

import compilador.isptec.lexico.Token;
import compilador.isptec.semantico.SymbolTable;
import compilador.isptec.semantico.VariableSymbol;

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
            System.err.printf("Erro na linha %d uso de um identificador não declarado",var.getLinha());
        }
    }
}
