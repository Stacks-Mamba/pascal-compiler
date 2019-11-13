package compilador.isptec.sintatico;
import compilador.isptec.lexico.Analex;
import compilador.isptec.lexico.Tokens;
import compilador.isptec.lexico.Token;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author hairt
 */
public class Parser {
    public static Token lookahead;
    private static Analex lexer;

    public static final int EXPECTED_ERROR = 1; //Erro quando só tem uma alternativa
    public static final int UNKNOWN_ERROR = 2; // Erro para várias alternativas

    private static void initParser(String arquivo) throws IOException
    {
        lexer = new Analex();
        lexer.abreArquivo(arquivo);
        lookahead = lexer.getToken();
    }


    //Error Handling method
    public static void error(Tokens expected,Symbol s,int type){
      switch(type){
        case 1:
            System.err.println("Erro na linha "+lookahead.getLinha());
            System.err.println("Linha "+lookahead.getLinha()+": Era esperado o token " + expected + " porém foi recebido "+ lookahead.getToken()+".");
            System.err.printf("Thrown by symbol: %s\n",s);
            System.exit(1);
            break;
        case 2:
            System.err.println(String.format("Símbolo inesperado:%s. Linha:%d",lookahead.getLexema(),lookahead.getLinha()));
            System.err.printf("Thrown by symbol: %s\n",s);
            System.exit(1);
            break;
      }
    }



    //Function that advances the input
    public static void consume()
    {
      System.out.println("Current input symbol: "+lookahead);
      //Get next input symbol
      lookahead = lexer.getToken();
      System.out.println("Next input symbol: "+lookahead);
    }

    public static void parse(String file) throws IOException
    {
        //Initialize parser
        initParser(file);
        //Comecar a execucao da análise léxica
        Grammar.initGrammar();
        int index = Grammar.program.checkSymbol(lookahead);
        if (index>-1)
            Grammar.program.getDerivation(index).derive();
        else
            Parser.error(lookahead.getToken(),Grammar.program,UNKNOWN_ERROR);
        //Mensagem de sucesso
        System.out.println("Compilacao Terminada com sucesso");
    }
    
    
    public static ArrayList<Derivable> first(Derivable s){
        ArrayList<Derivable> firstArray = new ArrayList();
        /*Actual code goes here*/
        if(s.getClass() == Terminal.class){
            firstArray.add(s);
        }
        else if(s.getClass()==NonTerminal.class){
            NonTerminal aux = (NonTerminal) s;
            for(Derivation d:aux.getDerivation()){
                Derivable symbol = d.getSymbols().get(0);
                if(first(symbol).contains(Grammar.empty)){
                    ArrayList<Derivable> symbs=d.getSymbols();
                    if(symbs.size()==1){
                       firstArray.addAll(first(symbol));
                    }
                    else{
                        ArrayList<Derivable> auxArray = first(symbs.get(0));               
                        auxArray.remove(Grammar.empty);
                        firstArray.addAll(auxArray);
                        int i = 1;
                        boolean addNext = true;
                        while(addNext && i< symbs.size()-1){
                            auxArray = first(symbs.get(i));               
                            auxArray.remove(Grammar.empty);
                            firstArray.addAll(auxArray);
                            addNext = first(symbs.get(i)).contains(Grammar.empty);
                            i++;
                        }
                        if(addNext){
                            firstArray.addAll(first(symbs.get(i)));
                        }
                    }
                }
                else{
                    firstArray.addAll(first(symbol));
                }
            }
        }
        else if(s.getClass()==Sequence.class){
            Sequence aux = (Sequence) s;
            Derivable symbol = aux.getSymbols().get(0);
            firstArray.addAll(first(symbol));
            firstArray.add(Grammar.empty);
        }
       /**********
        System.out.println("*********First Array*******");
        for(Derivable d:firstArray){
            System.out.println(d);
        }
        System.out.println("*********************");*/
        return firstArray;
    }
    
    public static void main(String[] args) throws IOException {
       // Parser.parse("source.txt");
       Grammar.initGrammar();
       for(Derivable d:first(Grammar.block)){
           System.out.println(d);
       }
    }

}
