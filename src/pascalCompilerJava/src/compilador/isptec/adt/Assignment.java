package compilador.isptec.adt;

public class Assignment implements AST {
    private AST leftSide;
    private AST rightSide;

    public Assignment(AST leftSide, AST rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public void visit(){
        System.out.println("Assignment\n_______________");
        leftSide.visit();
        rightSide.visit();
    }
}
