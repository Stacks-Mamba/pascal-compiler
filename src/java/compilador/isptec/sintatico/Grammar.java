/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;
import compilador.isptec.lexico.*;
import java.io.*;
/**
 *
 * @author stacks
 */
public class Grammar {
    //Símbolos terminais
    public static Terminal atribT = new Terminal("ATRIB",Tokens.ATRIB);
    public static Terminal numintT = new Terminal("NUMINT",Tokens.NUMINT);
    public static Terminal numrealT = new Terminal("NUMREAL",Tokens.NUMREAL);
    public static Terminal divisaoT = new Terminal("DIVISAO",Tokens.DIVISAO);
    public static Terminal idT = new Terminal("ID",Tokens.ID);
    public static Terminal eofT = new Terminal("EOF",Tokens.EOF);
    public static Terminal erroT = new Terminal("ERRO",Tokens.ERRO);
    public static Terminal igualT = new Terminal("IGUAL",Tokens.IGUAL);
    public static Terminal menorT = new Terminal("MENOR",Tokens.MENOR);
    public static Terminal diferenteT = new Terminal("DIFERENTE",Tokens.DIFERENTE);
    public static Terminal menorigualT = new Terminal("MENORIGUAL",Tokens.MENORIGUAL);
    public static Terminal maiorT = new Terminal("MAIOR",Tokens.MAIOR);
    public static Terminal maiorigualT = new Terminal("MAIORIGUAL",Tokens.MAIORIGUAL);
    public static Terminal maisT = new Terminal("MAIS",Tokens.MAIS);
    public static Terminal menosT = new Terminal("MENOS",Tokens.MENOS);
    public static Terminal vezesT = new Terminal("VEZES",Tokens.VEZES);
    public static Terminal pontoT = new Terminal("PONTO",Tokens.PONTO);
    public static Terminal pontopontoT = new Terminal("PONTOPONTO",Tokens.PONTOPONTO);
    public static Terminal doispontosT = new Terminal("DOISPONTOS",Tokens.DOISPONTOS);
    public static Terminal doispontosigualT = new Terminal("DOISPONTOSIGUAL",Tokens.DOISPONTOSIGUAL);
    public static Terminal abreparT = new Terminal("ABREPAR",Tokens.ABREPAR);
    public static Terminal abrefechaparT = new Terminal("ABREFECHAPAR",Tokens.ABREFECHAPAR);
    public static Terminal fechaparT = new Terminal("FECHAPAR",Tokens.FECHAPAR);
    public static Terminal abreretT = new Terminal("ABRERET",Tokens.ABRERET);
    public static Terminal fecharetT = new Terminal("FECHARET",Tokens.FECHARET);
    public static Terminal virgulaT = new Terminal("VIRGULA",Tokens.VIRGULA);
    public static Terminal barranT = new Terminal("BARRAN",Tokens.BARRAN);
    public static Terminal pontovirgulaT = new Terminal("PONTOVIRGULA",Tokens.PONTOVIRGULA);
    public static Terminal barraT = new Terminal("BARRA",Tokens.BARRA);
    public static Terminal tilT = new Terminal("TIL",Tokens.TIL);
    public static Terminal arrobaT = new Terminal("ARROBA",Tokens.ARROBA);
    public static Terminal cifraoT = new Terminal("CIFRAO",Tokens.CIFRAO);
    public static Terminal sustenidoT = new Terminal("SUSTENIDO",Tokens.SUSTENIDO);
    public static Terminal maisigualT = new Terminal("MAISIGUAL",Tokens.MAISIGUAL);
    public static Terminal menosigualT = new Terminal("MENOSIGUAL",Tokens.MENOSIGUAL);
    public static Terminal vezesigualT = new Terminal("VEZESIGUAL",Tokens.VEZESIGUAL);
    public static Terminal barraigualT = new Terminal("BARRAIGUAL",Tokens.BARRAIGUAL);
    public static Terminal abrecomentarioT = new Terminal("ABRECOMENTARIO",Tokens.ABRECOMENTARIO);
    public static Terminal fechacomentarioT = new Terminal("FECHACOMENTARIO",Tokens.FECHACOMENTARIO);
    public static Terminal abreparpontoT = new Terminal("ABREPARPONTO",Tokens.ABREPARPONTO);
    public static Terminal pontofechaparT = new Terminal("PONTOFECHAPAR",Tokens.PONTOFECHAPAR);
    public static Terminal barrabarraT = new Terminal("BARRABARRA",Tokens.BARRABARRA);
    public static Terminal underT = new Terminal("UNDER",Tokens.UNDER);
    public static Terminal tabulacaoT = new Terminal("TABULACAO",Tokens.TABULACAO);
    public static Terminal absoluteT = new Terminal("ABSOLUTE",Tokens.ABSOLUTE);
    public static Terminal elseT = new Terminal("ELSE",Tokens.ELSE);
    public static Terminal nilT = new Terminal("NIL",Tokens.NIL);
    public static Terminal setT = new Terminal("SET",Tokens.SET);
    public static Terminal andT = new Terminal("AND",Tokens.AND);
    public static Terminal endT = new Terminal("END",Tokens.END);
    public static Terminal notT = new Terminal("NOT",Tokens.NOT);
    public static Terminal shlT = new Terminal("SHL",Tokens.SHL);
    public static Terminal arrayT = new Terminal("ARRAY",Tokens.ARRAY);
    public static Terminal objectT = new Terminal("OBJECT",Tokens.OBJECT);
    public static Terminal shrT = new Terminal("SHR",Tokens.SHR);
    public static Terminal asmT = new Terminal("ASM",Tokens.ASM);
    public static Terminal forT = new Terminal("FOR",Tokens.FOR);
    public static Terminal ofT = new Terminal("OF",Tokens.OF);
    public static Terminal stringT = new Terminal("STRING",Tokens.STRING);
    public static Terminal intT = new Terminal("INT",Tokens.INT);
    public static Terminal realT = new Terminal("REAL",Tokens.REAL);
    public static Terminal doubleT = new Terminal("DOUBLE",Tokens.DOUBLE);
    public static Terminal charT = new Terminal("CHAR",Tokens.CHAR);
    public static Terminal boolT = new Terminal("BOOL",Tokens.BOOL);
    public static Terminal constanteT = new Terminal("CONSTANTE",Tokens.CONSTANTE);
    public static Terminal beginT = new Terminal("BEGIN",Tokens.BEGIN);
    public static Terminal functionT = new Terminal("FUNCTION",Tokens.FUNCTION);
    public static Terminal onT = new Terminal("ON",Tokens.ON);
    public static Terminal thenT = new Terminal("THEN",Tokens.THEN);
    public static Terminal breakT = new Terminal("BREAK",Tokens.BREAK);
    public static Terminal gotoT = new Terminal("GOTO",Tokens.GOTO);
    public static Terminal operatorT = new Terminal("OPERATOR",Tokens.OPERATOR);
    public static Terminal toT = new Terminal("TO",Tokens.TO);
    public static Terminal caseT = new Terminal("CASE",Tokens.CASE);
    public static Terminal ifT = new Terminal("IF",Tokens.IF);
    public static Terminal orT = new Terminal("OR",Tokens.OR);
    public static Terminal typeT = new Terminal("TYPE",Tokens.TYPE);
    public static Terminal constT = new Terminal("CONST",Tokens.CONST);
    public static Terminal implementationT = new Terminal("IMPLEMENTATION",Tokens.IMPLEMENTATION);
    public static Terminal packedT = new Terminal("PACKED",Tokens.PACKED);
    public static Terminal unitT = new Terminal("UNIT",Tokens.UNIT);
    public static Terminal constructorT = new Terminal("CONSTRUCTOR",Tokens.CONSTRUCTOR);
    public static Terminal inT = new Terminal("IN",Tokens.IN);
    public static Terminal procedureT = new Terminal("PROCEDURE",Tokens.PROCEDURE);
    public static Terminal untilT = new Terminal("UNTIL",Tokens.UNTIL);
    public static Terminal continueT = new Terminal("CONTINUE",Tokens.CONTINUE);
    public static Terminal inheritedT = new Terminal("INHERITED",Tokens.INHERITED);
    public static Terminal programT = new Terminal("PROGRAM",Tokens.PROGRAM);
    public static Terminal usesT = new Terminal("USES",Tokens.USES);
    public static Terminal destructorT = new Terminal("DESTRUCTOR",Tokens.DESTRUCTOR);
    public static Terminal inlineT = new Terminal("INLINE",Tokens.INLINE);
    public static Terminal recordT = new Terminal("RECORD",Tokens.RECORD);
    public static Terminal varT = new Terminal("VAR",Tokens.VAR);
    public static Terminal divT = new Terminal("DIV",Tokens.DIV);
    public static Terminal interfaceT = new Terminal("INTERFACE",Tokens.INTERFACE);
    public static Terminal reintroduceT = new Terminal("REINTRODUCE",Tokens.REINTRODUCE);
    public static Terminal whileT = new Terminal("WHILE",Tokens.WHILE);
    public static Terminal doT = new Terminal("DO",Tokens.DO);
    public static Terminal labelT = new Terminal("LABEL",Tokens.LABEL);
    public static Terminal strT = new Terminal("STR",Tokens.STR);
    public static Terminal repeatT = new Terminal("REPEAT",Tokens.REPEAT);
    public static Terminal withT = new Terminal("WITH",Tokens.WITH);
    public static Terminal downtoT = new Terminal("DOWNTO",Tokens.DOWNTO);
    public static Terminal modT = new Terminal("MOD",Tokens.MOD);
    public static Terminal selfT = new Terminal("SELF",Tokens.SELF);
    public static Terminal xorT = new Terminal("XOR",Tokens.XOR);
    public static Terminal asT = new Terminal("AS",Tokens.AS);
    public static Terminal classT = new Terminal("CLASS",Tokens.CLASS);
    public static Terminal exceptT = new Terminal("EXCEPT",Tokens.EXCEPT);
    public static Terminal exportsT = new Terminal("EXPORTS",Tokens.EXPORTS);
    public static Terminal finalizationT = new Terminal("FINALIZATION",Tokens.FINALIZATION);
    public static Terminal finallyT = new Terminal("FINALLY",Tokens.FINALLY);
    public static Terminal initializationT = new Terminal("INITIALIZATION",Tokens.INITIALIZATION);
    public static Terminal isT = new Terminal("IS",Tokens.IS);
    public static Terminal libraryT = new Terminal("LIBRARY",Tokens.LIBRARY);
    public static Terminal outT = new Terminal("OUT",Tokens.OUT);
    public static Terminal propertyT = new Terminal("PROPERTY",Tokens.PROPERTY);
    public static Terminal raiseT = new Terminal("RAISE",Tokens.RAISE);
    public static Terminal threadvarT = new Terminal("THREADVAR",Tokens.THREADVAR);
    public static Terminal tryT = new Terminal("TRY",Tokens.TRY);
    public static Terminal disposeT = new Terminal("DISPOSE",Tokens.DISPOSE);
    public static Terminal falseT = new Terminal("FALSE",Tokens.FALSE);
    public static Terminal trueT = new Terminal("TRUE",Tokens.TRUE);
    public static Terminal exitT = new Terminal("EXIT",Tokens.EXIT);
    public static Terminal newT = new Terminal("NEW",Tokens.NEW);
    public static Terminal otherwiseT = new Terminal("OTHERWISE",Tokens.OTHERWISE);
    public static Terminal fileT = new Terminal("FILE",Tokens.FILE);






    //Program Heading production
    public static NonTerminal programHeading = new NonTerminal("<Program Heading>");
    public static Terminal id = new Terminal("ID",Tokens.ID);
    public static Terminal virgula = new Terminal(",",Tokens.VIRGULA);
    public static Terminal program = new Terminal("program",Tokens.PROGRAM);
    public static Terminal parl = new Terminal("(",Tokens.ABREPAR);
    public static Terminal parr = new Terminal(")",Tokens.FECHAPAR);
    public static Terminal pv = new Terminal(";",Tokens.PONTOVIRGULA);




    public static void initPH(){
        Derivation d = new Derivation();
        d.addSymbol(program);
        d.addSymbol(id);
        d.addSymbol(parl);
        d.addSymbol(id);
        Sequence s = new Sequence();
        s.addSymbol(virgula);
        s.addSymbol(id);
        d.addSymbol(s);
        d.addSymbol(parr);
        d.addSymbol(pv);
        PH.addDerivation(d);
    }


    public static void getTokenFile() throws IOException{
        File f = new File("TokenDeclaration.txt");
        f.createNewFile();
        PrintWriter out = new PrintWriter(new FileOutputStream(f));
        for(Tokens t:Tokens.values()){
            out.printf("public static Terminal %sT = new Terminal(\"%s\",Tokens.%s);\n",t.name().toLowerCase(),t.name(),t.name());
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        getTokenFile();
    }
}