package compilador.isptec.adt;

import compilador.isptec.lexico.Tokens;

public class StandardType implements Type {

    private Tokens type;

    public StandardType(Tokens type) {
        this.type = type;
    }


    @Override
    public void showNode(){
        System.out.println("Standard type");
        System.out.println(type);
    }
}
