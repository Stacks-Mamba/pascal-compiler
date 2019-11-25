package compilador.isptec.adt;

public class Reference implements AST{

    private AST variable;

    public Reference(AST variable){
        this.variable = variable;
    }


    @Override
    public void showNode(){
        this.variable.showNode();
    }
}
