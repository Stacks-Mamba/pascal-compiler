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

    
    
    
    
    
    //Non terminal
    public static NonTerminal program = new NonTerminal("program");
    public static NonTerminal program_heading = new NonTerminal("program_heading");
    public static NonTerminal block = new NonTerminal("block");
    public static NonTerminal label_declaration_part = new NonTerminal("label_declaration_part");
    public static NonTerminal constant_definition_part = new NonTerminal("constant_definition_part");
    public static NonTerminal type_definition_part = new NonTerminal("type_definition_part");
    public static NonTerminal variable_declaration_part = new NonTerminal("variable_declaration_part");
    public static NonTerminal procedure_and_function_declaration_part = new NonTerminal("procedure_and_function_declaration_part");
    public static NonTerminal statement_part = new NonTerminal("statement_part");
    public static NonTerminal empty = new NonTerminal("empty");
    public static NonTerminal constant_definition = new NonTerminal("constant_definition");
    public static NonTerminal constant = new NonTerminal("constant");
    public static NonTerminal unsigned_number = new NonTerminal("unsigned_number");
    public static NonTerminal sign = new NonTerminal("sign");
    public static NonTerminal sign_1 = new NonTerminal("sign_1");
    public static NonTerminal type_definition = new NonTerminal("type_definition");
    public static NonTerminal type = new NonTerminal("type");
    public static NonTerminal scalar_type = new NonTerminal("scalar_type");
    public static NonTerminal subrange_type = new NonTerminal("subrange_type");
    public static NonTerminal structured_type = new NonTerminal("structured_type");
    public static NonTerminal array_type = new NonTerminal("array_type");
    public static NonTerminal record_type = new NonTerminal("record_type");
    public static NonTerminal set_type = new NonTerminal("set_type");
    public static NonTerminal file_type = new NonTerminal("file_type");
    public static NonTerminal index_type = new NonTerminal("index_type");
    public static NonTerminal field_list = new NonTerminal("field_list");
    public static NonTerminal fixed_part = new NonTerminal("fixed_part");
    public static NonTerminal fixed_part_1 = new NonTerminal("fixed_part_1");
    public static NonTerminal variant_part = new NonTerminal("variant_part");
    public static NonTerminal record_section = new NonTerminal("record_section");
    public static NonTerminal variant_type = new NonTerminal("variant_type");
    public static NonTerminal tag_field = new NonTerminal("tag_field");
    public static NonTerminal variant = new NonTerminal("variant");
    public static NonTerminal case_label_list = new NonTerminal("case_label_list");
    public static NonTerminal base_type = new NonTerminal("base_type");
    public static NonTerminal variable_declaration = new NonTerminal("variable_declaration");
    public static NonTerminal procedure_or_function_declaration = new NonTerminal("procedure_or_function_declaration");
    public static NonTerminal procedure_declaration = new NonTerminal("procedure_declaration");
    public static NonTerminal function_declaration = new NonTerminal("function_declaration");
    public static NonTerminal procedure_heading = new NonTerminal("procedure_heading");
    public static NonTerminal procedure_heading_1 = new NonTerminal("procedure_heading_1");
    public static NonTerminal formal_parameter_section = new NonTerminal("formal_parameter_section");
    public static NonTerminal parameter_group = new NonTerminal("parameter_group");
    public static NonTerminal function_heading = new NonTerminal("function_heading");
    public static NonTerminal function_heading_1 = new NonTerminal("function_heading_1");
    public static NonTerminal result_type = new NonTerminal("result_type");
    public static NonTerminal compound_statement = new NonTerminal("compound_statement");
    public static NonTerminal statement = new NonTerminal("statement");
    public static NonTerminal unlabelled_statement = new NonTerminal("unlabelled_statement");
    public static NonTerminal simple_statement = new NonTerminal("simple_statement");
    public static NonTerminal structured_statement = new NonTerminal("structured_statement");
    public static NonTerminal simple_statement_1 = new NonTerminal("simple_statement_1");
    public static NonTerminal go_to_statement = new NonTerminal("go_to_statement");
    public static NonTerminal variable_2 = new NonTerminal("variable_2");
    public static NonTerminal expression = new NonTerminal("expression");
    public static NonTerminal function_designator_1 = new NonTerminal("function_designator_1");
    public static NonTerminal assignment_statement = new NonTerminal("assignment_statement");
    public static NonTerminal variable = new NonTerminal("variable");
    public static NonTerminal array_variable = new NonTerminal("array_variable");
    public static NonTerminal record_variable = new NonTerminal("record_variable");
    public static NonTerminal simple_expression = new NonTerminal("simple_expression");
    public static NonTerminal expression_2 = new NonTerminal("expression_2");
    public static NonTerminal relational_operator = new NonTerminal("relational_operator");
    public static NonTerminal term = new NonTerminal("term");
    public static NonTerminal adding_operator = new NonTerminal("adding_operator");
    public static NonTerminal factor = new NonTerminal("factor");
    public static NonTerminal term_1 = new NonTerminal("term_1");
    public static NonTerminal multiplying_operator = new NonTerminal("multiplying_operator");
    public static NonTerminal factor_2 = new NonTerminal("factor_2");
    public static NonTerminal unsigned_constant = new NonTerminal("unsigned_constant");
    public static NonTerminal set = new NonTerminal("set");
    public static NonTerminal factor_3 = new NonTerminal("factor_3");
    public static NonTerminal function_designator_ = new NonTerminal("function_designator_");
    public static NonTerminal actual_parameter = new NonTerminal("actual_parameter");
    public static NonTerminal element_list = new NonTerminal("element_list");
    public static NonTerminal element = new NonTerminal("element");
    public static NonTerminal element_1 = new NonTerminal("element_1");
    public static NonTerminal procedure_statement = new NonTerminal("procedure_statement");
    public static NonTerminal conditional_statement = new NonTerminal("conditional_statement");
    public static NonTerminal repetitive_statement = new NonTerminal("repetitive_statement");
    public static NonTerminal with_statement = new NonTerminal("with_statement");
    public static NonTerminal if_statement = new NonTerminal("if_statement");
    public static NonTerminal case_statement = new NonTerminal("case_statement");
    public static NonTerminal if_statement_2 = new NonTerminal("if_statement_2");
    public static NonTerminal case_list_element = new NonTerminal("case_list_element");
    public static NonTerminal while_statement = new NonTerminal("while_statement");
    public static NonTerminal for_statement = new NonTerminal("for_statement");
    public static NonTerminal repeat_statement = new NonTerminal("repeat_statement");
    public static NonTerminal for_list = new NonTerminal("for_list");
    public static NonTerminal for_list_1 = new NonTerminal("for_list_1");
    public static NonTerminal record_variable_list = new NonTerminal("record_variable_list");
    
    public static void initSign(){
        sign.addDerivation(new Derivation(maisT),new Derivation(menosT));
    }
    
    public static void initPH(){
        Derivation d = new Derivation();
    }    
    
    public static void initGrammar(){
        initSign();
    }
}
