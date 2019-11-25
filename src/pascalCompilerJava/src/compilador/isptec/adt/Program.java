package compilador.isptec.adt;

public class Program implements AST {
    private String id;
    private AST block;

    public Program(String id, AST block) {
        this.id = id;
        this.block = block;
    }

    @Override
    public void visit(){
        block.visit();
    }
}
