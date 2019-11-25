package compilador.isptec.adt;
import compilador.isptec.lexico.Tokens;

public class BinaryOperation implements AST {
    private Tokens operator;
    private AST leftOperand;
    private AST rightOperand;

    public BinaryOperation(Tokens operator, AST leftOperand, AST rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public void visit(){
        System.out.println("Binary Operation\n_______________");
        leftOperand.visit();
        System.out.printf(" %s ",operator);
        rightOperand.visit();
    }


}
