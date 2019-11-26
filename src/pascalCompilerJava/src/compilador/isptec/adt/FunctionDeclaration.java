package compilador.isptec.adt;

import compilador.isptec.lexico.Token;
import compilador.isptec.semantico.SemanticAnalyzer;
import compilador.isptec.semantico.SymbolTable;
import compilador.isptec.semantico.VariableSymbol;
import compilador.isptec.sintatico.Error;

public class FunctionDeclaration implements AST {
    private Token id;

    public FunctionDeclaration(Token id){
        this.id = id;
    }


    @Override
    public void showNode(){
        System.out.println(id);
    }

    @Override
    public void visit(SymbolTable table){
        //Token type = type.getToken();
        if(table.lookup(id.getLexema().toLowerCase())==null){
            table.addEntry(new VariableSymbol(id.getLexema().toLowerCase()));
        }
        else{
            Error e = new Error(String.format("A funcão %s já foi declarada.",id.getLexema()),id.getLinha());
            SemanticAnalyzer.getInstance().reportError(e);
        }
    }
}
