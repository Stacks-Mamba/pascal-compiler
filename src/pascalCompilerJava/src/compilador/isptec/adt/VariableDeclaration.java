package compilador.isptec.adt;

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
}
