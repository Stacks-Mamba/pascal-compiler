package compilador.isptec.nodes;
import compilador.isptec.lexico.Tokens;

public class BinaryOperation extends AST {
    private Tokens operator;
    private AST leftOperand;
    private AST rightOperand;

    public BinaryOperation(Tokens operator, AST leftOperand, AST rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
}
