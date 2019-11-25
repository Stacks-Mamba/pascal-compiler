package compilador.isptec.nodes;

public class Assignment extends AST {
    private AST leftSide;
    private AST rightSide;

    public Assignment(AST leftSide, AST rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }
}
