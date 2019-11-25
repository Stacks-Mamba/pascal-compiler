package compilador.isptec.adt;

import compilador.isptec.lexico.Token;

public class Number implements AST {
    private Token number;

    public Number(Token number) {
        this.number = number;
    }

    @Override
    public void showNode() {
        System.out.println(number);
    }
}
