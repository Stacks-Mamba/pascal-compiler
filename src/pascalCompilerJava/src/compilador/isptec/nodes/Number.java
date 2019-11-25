package compilador.isptec.nodes;

import compilador.isptec.lexico.Token;
import compilador.isptec.lexico.Tokens;

public class Number extends AST {
    private Token number;

    public Number(Token number) {
        this.number = number;
    }
}
