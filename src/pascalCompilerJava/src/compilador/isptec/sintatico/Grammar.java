/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.sintatico;
import compilador.isptec.adt.*;
import compilador.isptec.lexico.*;

import java.util.ArrayList;


/**
 *
 * @author stacks
 */

/*Classe que contém todas as producoes da nossa gramática*/

public class Grammar {

    static AST program(){
        programHeading();
        AST block = block();
        Parser.consume(Tokens.PONTO);
        return block;
    }

    private static void programHeading(){
        Parser.consume(Tokens.PROGRAM);
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.ABREPAR);
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken()==Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.FECHAPAR);
        Parser.consume(Tokens.PONTOVIRGULA);
    }

    private static AST block(){
        labelDeclPart();
        constantDefPart();
        typeDefPart();
        ArrayList<AST> varDecls = varDeclPart();
        procAndFuncDeclPart();
        compoundStatement();
        ArrayList<AST> statements = compoundStatement();
        return new Block(varDecls,null,null);
    }

    private static void labelDeclPart(){
        if(Parser.lookahead.getToken()==Tokens.LABEL){
            Parser.consume(Tokens.LABEL);
            Parser.consume(Tokens.NUMINT);
            while(Parser.lookahead.getToken()==Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                Parser.consume(Tokens.NUMINT);
            }
            Parser.consume(Tokens.PONTOVIRGULA);
        }
    }

    private static void constantDefPart(){
        if(Parser.lookahead.getToken()==Tokens.CONST){
            Parser.consume(Tokens.CONST);
            constantDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            constantDefPart1();
        }
    }

    private static void constantDefPart1(){
        if(Parser.lookahead.getToken()==Tokens.ID){
            constantDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            constantDefPart1();
        }
    }

    private static void constantDef(){
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.IGUAL);
        constant();
    }

    private static void constant(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT ||
                Parser.lookahead.getToken()==Tokens.NUMREAL){
            unsignedNumber();
        }
        else if(Parser.lookahead.getToken()==Tokens.MAIS || Parser.lookahead.getToken()==Tokens.MENOS){
            sign();
            sign1();
        }
        else if(Parser.lookahead.getToken()==Tokens.ID){
            Parser.consume(Tokens.ID);
        }
        else if(Parser.lookahead.getToken()==Tokens.STRING){
            Parser.consume(Tokens.STRING);
        }
        else{
            Parser.error("Esperava se o início do símbolo constant");
        }
    }


    private static void sign1(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT || Parser.lookahead.getToken()==Tokens.NUMREAL){
            unsignedNumber();
        }
        else if(Parser.lookahead.getToken()==Tokens.ID){
            Parser.consume(Tokens.ID);
        }
        else{
            Parser.error("Esperava-se um número ou identificador");
        }
    }

    private static void unsignedNumber(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT){
            Parser.consume(Tokens.NUMINT);
        }
        else if( Parser.lookahead.getToken()==Tokens.NUMREAL){
            Parser.consume(Tokens.NUMREAL);
        }
        else{
            Parser.error("Esperava-se um número inteiro ou um número real");
        }
    }

    private static void sign(){
        if(Parser.lookahead.getToken()==Tokens.MAIS){
            Parser.consume(Tokens.MAIS);
        }
        else if(Parser.lookahead.getToken()==Tokens.MENOS){
            Parser.consume(Tokens.MENOS);
        }
        else{
            Parser.error("Esperava-se + ou -");
        }
    }

    private static void typeDefPart(){
        if(Parser.lookahead.getToken()==Tokens.TYPE){
            Parser.consume(Tokens.TYPE);
            typeDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            typeDefPart1();
        }
    }

    private static void typeDefPart1(){
        if(Parser.lookahead.getToken()==Tokens.ID){
            typeDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            typeDefPart1();
        }
    }

    private static void typeDef(){
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.IGUAL);
        type();
    }

    private static Type type(){

        Tokens lookahead = Parser.lookahead.getToken();
        Type type = new NullNode();
        if(lookahead==Tokens.ABREPAR){
            scalarType();
        }
        else if(lookahead==Tokens.NUMINT || lookahead==Tokens.NUMREAL){
            unsignedNumber();
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.MAIS || lookahead==Tokens.MENOS){
            sign();
            sign1();
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.STRING){
            Parser.consume(Tokens.STRING);
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.ID){
            Parser.consume(Tokens.ID);
            type1();
        }
        else if(lookahead==Tokens.REAL || lookahead==Tokens.BOOL ||
                lookahead==Tokens.CHAR || lookahead==Tokens.INT || lookahead == Tokens.TEXT){
            type = new StandardType(standardType());
        }
        else if(lookahead==Tokens.ARRAY || lookahead==Tokens.RECORD
                || lookahead ==Tokens.SET || lookahead == Tokens.FILE || lookahead == Tokens.PACKED){
            structuredType();
        }
        else if(lookahead == Tokens.ARROBA){
            Parser.consume(Tokens.ARROBA);
            Parser.consume(Tokens.ID);
        }
        else{
            Parser.error("Esperava-se o início de um type");
        }
        return type;
    }

    private static Tokens standardType(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.INT){
            Parser.consume(Tokens.INT);
            return Tokens.INT;
        }
        else if(lookahead == Tokens.CHAR){
            Parser.consume(Tokens.CHAR);
            return Tokens.CHAR;
        }
        else if(lookahead == Tokens.BOOL){
            Parser.consume(Tokens.BOOL);
            return Tokens.BOOL;
        }
        else if(lookahead == Tokens.REAL){
            Parser.consume(Tokens.REAL);
            return Tokens.REAL;
        }
        else if(lookahead == Tokens.TEXT){
            Parser.consume(Tokens.TEXT);
            return Tokens.TEXT;
        }
        return null;
    }

    private static void type1(){
        if(Parser.lookahead.getToken()==Tokens.PONTOPONTO){
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
    }

    private static void scalarType(){
        Parser.consume(Tokens.ABREPAR);
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken()==Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.FECHAPAR);
    }


    private static void unpackedStructuredType(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ARRAY){
            arrayType();
        }
        else if(lookahead == Tokens.RECORD){
            recordType();
        }
        else if (lookahead == Tokens.SET){
            setType();
        }
        else if(lookahead == Tokens.FILE) {
            fileType();
        }
        else{
            Parser.error("Esperava-se o início  de um unpacked structured type");
        }
    }

    private static void structuredType(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ARRAY || lookahead == Tokens.RECORD ||
                lookahead == Tokens.SET||lookahead == Tokens.FILE){
            unpackedStructuredType();
        }
        else if(lookahead == Tokens.PACKED){
            Parser.consume(Tokens.PACKED);
            unpackedStructuredType();
        }
        else{
            Parser.error("Esperava-se o início de um structured type");
        }
    }

    private static void arrayType(){
        Parser.consume(Tokens.ARRAY);
        Parser.consume(Tokens.ABRERET);
        indexType();
        while(Parser.lookahead.getToken()==Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            indexType();
        }
        Parser.consume(Tokens.FECHARET);
        Parser.consume(Tokens.OF);
        type();
    }

    private static void indexType(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ABREPAR){
            scalarType();
        }
        else if(lookahead == Tokens.NUMINT || lookahead == Tokens.NUMREAL){
            unsignedNumber();
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.MAIS || lookahead==Tokens.MENOS){
            sign();
            sign1();
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.STRING){
            Parser.consume(Tokens.STRING);
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
        else if(lookahead==Tokens.ID){
            Parser.consume(Tokens.ID);
            type1();
        }
        else{
            Parser.error("Esperava-se o início de um index type");
        }
    }

    private static void recordType(){
        Parser.consume(Tokens.RECORD);
        fieldList();
        Parser.consume(Tokens.END);
    }

    private static void fieldList(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.CASE){
            variantType();
        }
        else{
            fixedPart();
            fixedPart1();
        }
    }

    private static void fixedPart(){
        recordSection();
        while(Parser.lookahead.getToken() == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            recordSection();
        }
    }


    private static void fixedPart1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if (lookahead == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            variantType();
        }
    }

    private static void recordSection(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID){
            Parser.consume(Tokens.ID);
            while(Parser.lookahead.getToken() == Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                Parser.consume(Tokens.ID);
            }
            Parser.consume(Tokens.PONTOVIRGULA);
            type();
        }
    }

    private static void variantType(){
        Parser.consume(Tokens.CASE);
        tagField();
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.OF);
        variant();
        while(Parser.lookahead.getToken() == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            variant();
        }
    }

    private static void tagField(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID) {
            Parser.consume(Tokens.ID);
            Parser.consume(Tokens.DOISPONTOS);
        }
    }

    private static void variant(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.NUMINT || lookahead == Tokens.NUMREAL
        || lookahead == Tokens.MAIS || lookahead == Tokens.MENOS ||
          lookahead == Tokens.ID || lookahead == Tokens.STRING){
            caseLabelList();
            Parser.consume(Tokens.DOISPONTOS);
            Parser.consume(Tokens.ABREPAR);
            fieldList();
            Parser.consume(Tokens.FECHAPAR);
        }
    }


    private static void setType(){
        Parser.consume(Tokens.SET);
        Parser.consume(Tokens.OF);
        indexType();
    }

    private static void fileType(){
        Parser.consume(Tokens.FILE);
        Parser.consume(Tokens.OF);
        type();
    }

    private static ArrayList<AST> varDeclPart(){
        Tokens lookahead = Parser.lookahead.getToken();
        //Array de declaracoes
        ArrayList<AST> declarations = new ArrayList<>();
        if(lookahead == Tokens.VAR){
            Parser.consume(Tokens.VAR);
            declarations.addAll(varDecl());
            Parser.consume(Tokens.PONTOVIRGULA);
            declarations.addAll(varDeclPart1());
        }
        return declarations;
    }

    private static ArrayList<AST> varDeclPart1(){
        Tokens lookahead = Parser.lookahead.getToken();
        //Array de declaracoes
        ArrayList<AST> declarations = new ArrayList<>();
        if(lookahead == Tokens.ID){
            declarations.addAll(varDecl());
            Parser.consume(Tokens.PONTOVIRGULA);
            declarations.addAll(varDeclPart1());
        }
        return declarations;
    }

    private static ArrayList<VariableDeclaration> varDecl(){
        ArrayList<VariableDeclaration> declarations = new ArrayList<>();
        declarations.add(new VariableDeclaration(new Variable(Parser.lookahead)));
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken() == Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            declarations.add(new VariableDeclaration(new Variable(Parser.lookahead)));
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.DOISPONTOS);
        Type declType = type();
        for(VariableDeclaration vd: declarations){
            vd.setType(declType);
        }
        return declarations;
    }

    private static void procAndFuncDeclPart(){
        while(Parser.lookahead.getToken() == Tokens.FUNCTION || Parser.lookahead.getToken()==Tokens.PROCEDURE){
            procOrFuncDecl();
        }
    }

    private static void procOrFuncDecl(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.PROCEDURE){
            procedureDecl();
        }
        else if(lookahead == Tokens.FUNCTION){
            functionDecl();
        }
        else{
            Parser.error("Esperava-se procedure ou function .");
        }
    }

    private static void procedureDecl(){
        procedureHeading();
        block();
    }

    private static void procedureHeading(){
        Parser.consume(Tokens.PROCEDURE);
        Parser.consume(Tokens.ID);
        procedureHeading1();
    }

    private static void procedureHeading1(){
        Tokens lookahead = Parser.lookahead.getToken();

        if(lookahead == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
        }
        else if (lookahead == Tokens.ABREPAR){
            paramSection();
        }
        else{
            Parser.error("Esperava-se ; ou ( .");
        }
    }

    private static void paramSection(){
        Parser.consume(Tokens.ABREPAR);
        formalParamSection();
        while(Parser.lookahead.getToken() == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            formalParamSection();
        }
        Parser.consume(Tokens.FECHAPAR);
    }

    private static void formalParamSection(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID){
            varDecl();
        }
        else if (lookahead == Tokens.VAR){
            Parser.consume(Tokens.VAR);
            varDecl();
        }
        else if(lookahead == Tokens.FUNCTION){
            Parser.consume(Tokens.FUNCTION);
            varDecl();
        }
        else if(lookahead == Tokens.PROCEDURE){
            Parser.consume(Tokens.PROCEDURE);
            Parser.consume(Tokens.ID);
            while(Parser.lookahead.getToken() == Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                Parser.consume(Tokens.ID);
            }
        }
        else{
            Parser.error("Esperava-se o início da formal parameter section.");
        }
    }

    private static void functionDecl(){
        functionHeading();
        block();
    }

    private static void functionHeading(){
        Parser.consume(Tokens.FUNCTION);
        Parser.consume(Tokens.ID);
        functionHeading1();
    }

    private static void functionHeading1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.DOISPONTOS) {
            Parser.consume(Tokens.DOISPONTOS);
            Parser.consume(Tokens.ID);
            Parser.consume(Tokens.PONTOVIRGULA);
        }
        else if(lookahead == Tokens.ABREPAR){
            paramSection();
            Parser.consume(Tokens.DOISPONTOS);
            type();
            Parser.consume(Tokens.PONTOVIRGULA);
        }
    }

    private static AST statement(){
        Tokens lookahead = Parser.lookahead.getToken();
        AST statement = new NullStatement();
        if(lookahead == Tokens.NUMINT){
            Parser.consume(Tokens.NUMINT);
            Parser.consume(Tokens.DOISPONTOS);
            statement = unlabelledStatement();
        }
        else{
            statement = unlabelledStatement();
        }
        return statement;
    }

    private static AST unlabelledStatement(){
        Tokens lookahead = Parser.lookahead.getToken();
        AST statement = new NullStatement();
        if(lookahead == Tokens.BEGIN || lookahead == Tokens.IF||
                lookahead == Tokens.CASE || lookahead ==Tokens.WHILE ||
                lookahead == Tokens.REPEAT||lookahead == Tokens.FOR||
                lookahead == Tokens.WITH
            ){
            statement = structuredStatement();
        }
        else{
            statement = simpleStatement();
        }
        return statement;
    }

    private static void simpleStatement(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID){
            Parser.consume(Tokens.ID);
            simpleStatement1();
        }
        else if (lookahead == Tokens.GOTO){
            goToStatement();
        }
    }

    private static void simpleStatement1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ABRERET || lookahead==Tokens.PONTO||lookahead==Tokens.DOISPONTOSIGUAL){
            assignment();
        }
        else{
            functionDesignator1();
        }
    }

    private static void assignment(){
        System.out.println("In assignment");
        variable2();
        Parser.consume(Tokens.DOISPONTOSIGUAL);
        expression();
    }

    private static void variable(){
        Parser.consume(Tokens.ID);
        variable2();
    }

    private static void variable2(){
        Tokens lookahead = Parser.lookahead.getToken();

        if(lookahead == Tokens.ABRERET){
            arrayVariable();
            variable2();
        }
        else if(lookahead == Tokens.PONTO){
            recordVariable();
            variable2();
        }
        else if(lookahead == Tokens.ARROBA){
            Parser.consume(Tokens.ARROBA);
        }
    }


    private static void recordVariable(){
        Parser.consume(Tokens.PONTO);
        Parser.consume(Tokens.ID);
    }


    private static void arrayVariable(){
        Parser.consume(Tokens.ABRERET);
        expression();
        while(Parser.lookahead.getToken() == Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            expression();
        }
        Parser.consume(Tokens.FECHARET);
    }

    private static void expression(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.MAIS|| lookahead == Tokens.MENOS||
                lookahead == Tokens.ID||lookahead == Tokens.NUMINT||
                lookahead == Tokens.NUMREAL||
                lookahead == Tokens.STRING ||
                lookahead == Tokens.NIL ||
                lookahead==Tokens.ABREPAR || lookahead == Tokens.NOT|
                lookahead == Tokens.ABRERET){
            simpleExpression();
            expression2();
        }
        else{
            Parser.error("Esperava-se o início de uma expression");
        }
    }

    private static void expression2(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.IGUAL||lookahead == Tokens.DIFERENTE||
                lookahead == Tokens.MENOR||
                lookahead == Tokens.MENORIGUAL||
                lookahead == Tokens.MAIORIGUAL||
                lookahead == Tokens.MAIOR|| lookahead == Tokens.IN ){
            relationalOperator();
            simpleExpression();
        }
    }

    private static void relationalOperator(){
        Tokens lookahead = Parser.lookahead.getToken();
        switch(lookahead){
            case IGUAL:
                Parser.consume(Tokens.IGUAL);
                break;
            case DIFERENTE:
                Parser.consume(Tokens.DIFERENTE);
                break;
            case MENOR:
                Parser.consume(Tokens.MENOR);
                break;
            case MENORIGUAL:
                Parser.consume(Tokens.MENORIGUAL);
                break;
            case MAIOR:
                Parser.consume(Tokens.MAIOR);
                break;
            case MAIORIGUAL:
                Parser.consume(Tokens.MAIORIGUAL);
                break;
            case IN:
                Parser.consume(Tokens.IN);
                break;
            default:
                Parser.error("Esperava-se um relational operator.");
        }
    }

    private static void simpleExpression(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID || lookahead == Tokens.NUMINT||
                lookahead == Tokens.NUMREAL||
                lookahead == Tokens.STRING ||
                lookahead == Tokens.NIL ||
                lookahead==Tokens.ABREPAR ||
                lookahead == Tokens.NOT||
                lookahead == Tokens.ABRERET ){
            term();
            simpleExpression1();
        }

        else if(lookahead == Tokens.MAIS || lookahead ==Tokens.MENOS){
            sign();
            term();
            simpleExpression1();
        }
        else{
            Parser.error("Esperava-se o início de uma simple expression");
        }
    }

    private static void simpleExpression1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.MAIS || lookahead ==Tokens.MENOS ||
        lookahead == Tokens.OR){
            addingOperator();
            term();
            simpleExpression1();
        }
    }

    private static void addingOperator(){
        Tokens lookahead = Parser.lookahead.getToken();
        switch(lookahead){
            case MAIS:
                Parser.consume(Tokens.MAIS);
                break;
            case MENOS:
                Parser.consume(Tokens.MENOS);
                break;
            case OR:
                Parser.consume(Tokens.OR);
                break;
            default:
                Parser.error("Esperava-se um adding operator");
                break;
        }
    }

    private static void term(){
        factor();
        term1();
    }

    private static void term1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.VEZES || lookahead ==Tokens.DIVISAO ||
                lookahead == Tokens.DIV || lookahead == Tokens.MOD ||
                lookahead == Tokens.AND){
            multiplyingOperator();
            factor();
            term1();
        }
    }


    private static void multiplyingOperator(){
        Tokens lookahead = Parser.lookahead.getToken();
        switch(lookahead){
            case VEZES:
                Parser.consume(Tokens.VEZES);
                break;
            case DIVISAO:
                Parser.consume(Tokens.DIVISAO);
                break;
            case DIV:
                Parser.consume(Tokens.DIV);
                break;
            case MOD:
                Parser.consume(Tokens.MOD);
                break;
            case AND:
                Parser.consume(Tokens.AND);
                break;
            default:
                Parser.error("Esperava-se um multiplying operator");
                break;
        }
    }

    private static void factor(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID){
            Parser.consume(Tokens.ID);
            factor2();
        }
        else if(lookahead == Tokens.NUMINT||
                lookahead == Tokens.NUMREAL||
                lookahead == Tokens.STRING || lookahead == Tokens.NIL){
            unsignedConstant();
        }
         else if(lookahead==Tokens.ABREPAR) {
             Parser.consume(Tokens.ABREPAR);
             expression();
             Parser.consume(Tokens.FECHAPAR);

        }
         else if(lookahead == Tokens.ABRERET){
             set();
        }
        else if (lookahead == Tokens.NOT){
            Parser.consume(Tokens.NOT);
            factor();
        }
        else{
            Parser.error("Esperava-se o início de um factor");
        }
    }

    private static void factor2(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.PONTO || lookahead == Tokens.ABRERET){
            variable2();
            factor3();
        }
        else{
            functionDesignator1();
        }
    }

    private static void factor3(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ABRERET){
            arrayVariable();
        }
        else if(lookahead == Tokens.PONTO){
            recordVariable();
        }
    }

    private static void unsignedConstant(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.NUMINT || lookahead ==Tokens.NUMREAL){
            unsignedNumber();
        }
        else if (lookahead == Tokens.STRING){
            Parser.consume(Tokens.STRING);
        }
        else if (lookahead == Tokens.NIL){
            Parser.consume(Tokens.NIL);
        }
        else{
            Parser.error("Esperava-se um unsigned constant");
        }
    }

    private static void functionDesignator1(){
        System.out.println("in function designator.");
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ABREPAR){
            Parser.consume(Tokens.ABREPAR);
            actualParamater();
            while(Parser.lookahead.getToken() == Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                actualParamater();
            }
            Parser.consume(Tokens.FECHAPAR);
        }
    }

    private static void set(){
        Parser.consume(Tokens.ABRERET);
        elementList();
        Parser.consume(Tokens.FECHARET);
    }

    private static void elementList(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.MAIS|| lookahead == Tokens.MENOS||
                lookahead == Tokens.ID||lookahead == Tokens.NUMINT||
                lookahead == Tokens.NUMREAL||
                lookahead == Tokens.STRING ||
                lookahead == Tokens.NIL ||
                lookahead==Tokens.ABREPAR || lookahead == Tokens.NOT|
                lookahead == Tokens.ABRERET){
            expression();
            while(Parser.lookahead.getToken()==Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                element();
            }
        }
    }

    private static void element(){
        expression();
        element1();
    }

    private static void element1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if (lookahead == Tokens.PONTOPONTO){
            Parser.consume(Tokens.PONTOPONTO);
            expression();
        }
    }

    private static void actualParamater(){
        System.out.println("In actual parameter");
        expression();
    }



    private static void goToStatement(){
        Parser.consume(Tokens.GOTO);
        Parser.consume(Tokens.NUMINT);
    }

    private static void structuredStatement(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.BEGIN){
            compoundStatement();
        }
        else if(lookahead == Tokens.IF|| lookahead == Tokens.CASE){
            conditionalStatement();
        }
        else if(lookahead ==Tokens.WHILE ||
                lookahead == Tokens.REPEAT||
                lookahead == Tokens.FOR){
            repetitiveStatement();
        }
        else if(lookahead == Tokens.WITH){
            withStatement();
        }
        else{
            Parser.error("Esperava-se o início de um structured statement");
        }

    }

    private static AST compoundStatement(){
        Parser.consume(Tokens.BEGIN);
        ArrayList<AST> statements = new ArrayList<>();
        statements.add(statement());
        while(Parser.lookahead.getToken()==Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            statements.add(statement());
        }
        Parser.consume(Tokens.END);
        return statements;
    }

    private static void conditionalStatement(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.IF){
            ifStatement();
        }
        else if(lookahead == Tokens.CASE){
            caseStatement();
        }
    }

    private static void ifStatement(){
        Parser.consume(Tokens.IF);
        expression();
        Parser.consume(Tokens.THEN);
        statement();
        ifStatement2();
    }

    private static void ifStatement2(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ELSE){
            Parser.consume(Tokens.ELSE);
            statement();
        }
    }

    private static void caseStatement(){
        Parser.consume(Tokens.CASE);
        expression();
        Parser.consume(Tokens.OF);
        caseListElement();
        while(Parser.lookahead.getToken() == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            caseListElement();
        }
        Parser.consume(Tokens.END);
        caseLabelList();
    }

    private static void caseListElement(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead==Tokens.NUMINT || lookahead==Tokens.NUMREAL) {
            caseLabelList();
            Parser.consume(Tokens.PONTO);
            statement();
        }
    }

    private static void caseLabelList(){
        constant();
        while(Parser.lookahead.getToken()==Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            constant();
        }

    }

    private static void repetitiveStatement(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.WHILE){
            whileStatement();
        }
        else if(lookahead == Tokens.REPEAT){
            repeatStatement();
        }
        else if(lookahead == Tokens.FOR){
            forStatement();
        }
        else{
            Parser.error("Esperava-se while,repeat ou for.");
        }
    }

    private static void whileStatement(){
        Parser.consume(Tokens.WHILE);
        expression();
        Parser.consume(Tokens.DO);
        statement();
    }

    private static void repeatStatement(){
        Parser.consume(Tokens.REPEAT);
        statement();
        while(Parser.lookahead.getToken() == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            statement();
        }
        Parser.consume(Tokens.UNTIL);
        expression();
    }

    private static void forStatement(){
        Parser.consume(Tokens.FOR);
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.DOISPONTOSIGUAL);
        forList();
        Parser.consume(Tokens.DO);
        statement();
    }

    private static void forList(){
        expression();
        forList1();
    }

    private static void forList1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.TO){
            Parser.consume(Tokens.TO);
            expression();
        }
        else if(lookahead == Tokens.DOWNTO){
            expression();
        }
        else{
            Parser.error("Esperava-se 'to' ou 'downto'.");
        }
    }

    private static void withStatement(){
        Parser.consume(Tokens.WITH);
        recordVariableList();
        Parser.consume(Tokens.DO);
        statement();
    }

    private static void recordVariableList(){
        variable();
        while(Parser.lookahead.getToken() == Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            variable();
        }
    }




}
