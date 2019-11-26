package compilador.isptec.adt;

import compilador.isptec.lexico.Tokens;
import compilador.isptec.semantico.SymbolTable;

public class StandardType extends Type {


    public StandardType(Tokens type) {
        super(type);
    }


    @Override
    public void showNode(){
        System.out.println("Standard type");
        System.out.println(super.getType());
    }

    @Override
    public void visit(SymbolTable table) {

    }
}
