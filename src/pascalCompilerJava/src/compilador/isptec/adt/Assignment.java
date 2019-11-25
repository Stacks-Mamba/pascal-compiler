package compilador.isptec.adt;

public class Assignment implements AST {
    private AST leftSide;
    private AST rightSide;

    public Assignment(AST leftSide, AST rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public void showNode(){
        System.out.println("Assignment\n_______________");
        leftSide.showNode();
        rightSide.showNode();
    }
}
