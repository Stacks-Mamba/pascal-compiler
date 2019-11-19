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

/*Classe que contém todas as producoes da nossa gramática*/

public class Grammar {

    public static void program(){
        programHeading();
        block();
        Parser.consume(Tokens.PONTO);
    }

    public static void programHeading(){
        Parser.consume(Tokens.PROGRAM);
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.ABREPAR);
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken()==Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.FECHAPAR);
        Parser.consume(Tokens.PONTOVIRGULA);
    }

    public static void block(){
        labelDeclPart();
        constantDefPart();
        typeDefPart();
        varDeclPart();
        procAndFuncDeclPart();
        statementPart();
    }

    public static void labelDeclPart(){
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

    public static void constantDefPart(){
        if(Parser.lookahead.getToken()==Tokens.CONST){
            Parser.consume(Tokens.CONST);
            constantDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            constantDefPart1();
        }
    }

    public static void constantDefPart1(){
        if(Parser.lookahead.getToken()==Tokens.ID){
            constantDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            constantDefPart1();
        }
    }

    public static void constantDef(){
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.IGUAL);
        constant();
    }

    public static void constant(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT || Parser.lookahead.getToken()==Tokens.NUMREAL){
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
            Parser.error(Tokens.ID,Parser.UNKNOWN_ERROR);
        }
    }


    public static void sign1(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT || Parser.lookahead.getToken()==Tokens.NUMREAL){
            unsignedNumber();
        }
        else if(Parser.lookahead.getToken()==Tokens.ID){
            Parser.consume(Tokens.ID);
        }
        else{
            Parser.error(Tokens.ID,Parser.UNKNOWN_ERROR);
        }
    }

    public static void unsignedNumber(){
        if (Parser.lookahead.getToken()==Tokens.NUMINT){
            Parser.consume(Tokens.NUMINT);
        }
        else if( Parser.lookahead.getToken()==Tokens.NUMREAL){
            Parser.consume(Tokens.REAL);
        }
        else{
            Parser.error(Tokens.ID,Parser.UNKNOWN_ERROR);
        }
    }

    public static void sign(){
        if(Parser.lookahead.getToken()==Tokens.MAIS)){
            Parser.consume(Tokens.MAIS);
        }
        else if(Parser.lookahead.getToken()==Tokens.MENOS){
            Parser.consume(Tokens.MENOS);
        }
        else{
            Parser.error(Tokens.MAIS,Parser.UNKNOWN_ERROR);
        }
    }

    public static void typeDefPart(){
        if(Parser.lookahead.getToken()==Tokens.TYPE){
            Parser.consume(Tokens.TYPE);
            typeDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            typeDefPart1();
        }
    }

    public static void typeDefPart1(){
        if(Parser.lookahead.getToken()==Tokens.ID){
            typeDef();
            Parser.consume(Tokens.PONTOVIRGULA);
            typeDefPart1();
        }
    }

    public static void typeDef(){
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.IGUAL);
        type();
    }

    public static void type(){

        Tokens lookahead = Parser.lookahead.getToken();
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
        else if(lookahead==Tokens.ARRAY || lookahead==Tokens.RECORD
                || lookahead ==Tokens.SET || lookahead == Tokens.FILE){
            structuredType();
        }
    }

    public static void type1(){
        if(Parser.lookahead.getToken()==Tokens.PONTOPONTO){
            Parser.consume(Tokens.PONTOPONTO);
            constant();
        }
    }

    public static void scalarType(){
        Parser.consume(Tokens.ABREPAR);
        Parser.consume(Tokens.ID);
        while(Parser.lookahead.getToken()==Tokens.VIRGULA){
            Parser.consume(Tokens.VIRGULA);
            Parser.consume(Tokens.ID);
        }
        Parser.consume(Tokens.FECHAPAR);
    }


    public static void structuredType(){
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
            Parser.error(Tokens.MAIS,Parser.UNKNOWN_ERROR);
        }
    }

    public static void arrayType(){
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

    public static void indexType(){
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
            Parser.error(Tokens.ABREPAR,Parser.UNKNOWN_ERROR);
        }
    }

    public static void recordType(){
        Parser.consume(Tokens.RECORD);
        fieldList();
        Parser.consume(Tokens.END);
    }

    public static void fieldList(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.CASE){
            variantType();
        }
        else{
            fixedPart();
            fixedPart1();
        }
    }

    public static void fixedPart(){
        Tokens lookahead = Parser.lookahead.getToken();
        recordSection();
        while(lookahead == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            recordSection();
        }
    }


    public static void fixedPart1(){
        Tokens lookahead = Parser.lookahead.getToken();
        if (lookahead == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            variantType();
        }
    }

    public static void recordSection(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID){
            Parser.consume(Tokens.ID);
            while(lookahead == Tokens.VIRGULA){
                Parser.consume(Tokens.VIRGULA);
                Parser.consume(Tokens.ID);
            }
            Parser.consume(Tokens.PONTOVIRGULA);
            type();
        }
    }

    public static void variantType(){
        Tokens lookahead = Parser.lookahead.getToken();
        Parser.consume(Tokens.CASE);
        tagField();
        Parser.consume(Tokens.ID);
        Parser.consume(Tokens.OF);
        variant();
        while(lookahead == Tokens.PONTOVIRGULA){
            Parser.consume(Tokens.PONTOVIRGULA);
            variant();
        }
    }

    public static void tagField(){
        Tokens lookahead = Parser.lookahead.getToken();
        if(lookahead == Tokens.ID) {
            Parser.consume(Tokens.ID);
            Parser.consume(Tokens.DOISPONTOS);
        }
    }

    public static void variant(){
        Tokens lookahead = Parser.lookahead.getToken();
        
    }





}
