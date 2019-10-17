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
        /*Actual code gies here*/
        if(s.getClass() == Terminal.class){
            firstArray.add(s);
            return firstArray;
        }
        else if(s.getClass()==NonTerminal.class){
            NonTerminal aux = (NonTerminal) s;
            
            for(Derivation d:aux.getDerivation()){
                Derivable symbol = d.getSymbols().get(0);
                if(first(symbol).contains(Grammar.empty)){
                    ArrayList<Derivable> symbs=d.getSymbols();
                    if(symbs.size()==1){
                       firstArray.add(Grammar.empty);
                    }
                    else{
                        int i = 1;
                        boolean hasEmpty = true;
                        while(hasEmpty && i!= symbs.size()){
                            ArrayList<Derivable> auxArray = first(symbs.get(i-1));
                            auxArray.remove(Grammar.empty);
                            firstArray.addAll(auxArray);
                            if(! first(symbs.get(i)).contains(Grammar.empty)){
                                hasEmpty = false;
                            }
                            i++;
                        }
                        if(hasEmpty){
                            firstArray.addAll(first(symbs.get(i-1)));
                            
                        }
                    }
                }
                else{
                    firstArray.addAll(first(d.getSymbols().get(0)));
                }
            }
        }
        /***********/
        return firstArray;
    }
    
    public static void main(String[] args) throws IOException {
       // Parser.parse("source.txt");
       NonTerminal type = new NonTerminal("type");
       NonTerminal simple = new NonTerminal("simple");
       type.addDerivation(new Derivation(simple),new Derivation(Grammar.vezesT,Grammar.idT),new Derivation(Grammar.arrayT,Grammar.abreretT,simple,Grammar.fecharetT,Grammar.ofT,type));
       simple.addDerivation(new Derivation(Grammar.intT),new Derivation(Grammar.charT),new Derivation(Grammar.numintT,Grammar.pontopontoT,Grammar.numintT));
       for(Derivable d:first(type)){
           System.out.println(d);
       }
       
    }

}
