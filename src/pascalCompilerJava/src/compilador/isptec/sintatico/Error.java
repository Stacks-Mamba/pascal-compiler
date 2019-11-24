package compilador.isptec.sintatico;

public class Error {
    String message;
    int lineNumber;

    public Error(String message,int lineNumber){
        this.message = message;
        this.lineNumber = lineNumber;
    }

    public void throwError(){
        System.err.println("Linha "+lineNumber+" : "+message);
    }
}
