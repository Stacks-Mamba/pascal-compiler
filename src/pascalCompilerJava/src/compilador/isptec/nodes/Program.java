package compilador.isptec.nodes;

public class Program extends AST {
    private String id;
    private AST block;

    public Program(String id, AST block) {
        this.id = id;
        this.block = block;
    }
}
