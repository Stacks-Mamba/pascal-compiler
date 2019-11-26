package compilador.isptec.adt;

import compilador.isptec.lexico.Token;
import compilador.isptec.semantico.SymbolTable;
import compilador.isptec.semantico.VariableSymbol;

public class VariableDeclaration implements AST {
    private Variable variable;
    private Type type;

    public VariableDeclaration(Variable variable, Type type) {
        this.variable = variable;
        this.type = type;
    }

    public VariableDeclaration(Variable variable) {
        this.variable = variable;
    }

    public void setType(Type type){
        this.type = type;
    }

    @Override
    public void showNode(){
        System.out.println("Variable Declaration\n_______________");
        variable.showNode();
        type.showNode();
    }

    @Override
    public void visit(SymbolTable table) {
        Token var =  variable.getToken();
        //Token type = type.getToken();
        if(table.lookup(var.getLexema().toLowerCase())==null){
            table.addEntry(new VariableSymbol(var.getLexema().toLowerCase()));
        }
        else{
            System.out.printf("Erro na linha %d esta variável já foi declarada",var.getLinha());
        }
    }
}
