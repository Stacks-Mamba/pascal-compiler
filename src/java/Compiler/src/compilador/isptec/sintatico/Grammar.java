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
    public static Terminal empty = new Terminal(Terminal.EMPTY_SYMBOL,Tokens.ERRO);
    
    
    
    
    
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
    public static NonTerminal constant_definition = new NonTerminal("constant_definition");
    public static NonTerminal constant = new NonTerminal("constant");
    public static NonTerminal unsigned_number = new NonTerminal("unsigned_number");
    public static NonTerminal sign = new NonTerminal("sign");
    public static NonTerminal sign_1 = new NonTerminal("sign_1");
    public static NonTerminal type_definition = new NonTerminal("type_definition");
    public static NonTerminal type = new NonTerminal("type");
    public static NonTerminal type1 = new NonTerminal("type1");
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
    public static NonTerminal simple_expression_1 = new NonTerminal("simple_expression_1");
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
    
    //Primeiro símbolo da gramática
    public static NonTerminal FIRST_PRODUCTION = Grammar.program;
    
    public static void produceSign(){
        sign.addRightSide(new RightSide(maisT),new RightSide(menosT));
    }
    
    public static void produceUnsignedNumber(){
        unsigned_number.addRightSide(new RightSide(numintT),new RightSide(numrealT));
    }
    
    public static void produceGoToStatement(){
        go_to_statement.addRightSide(new RightSide(gotoT,numintT));
    }
    
    public static void produceSign1(){
        sign_1.addRightSide(new RightSide(unsigned_number),new RightSide(idT));
    }
    
    public static void produceConstant(){
        constant.addRightSide(new RightSide(unsigned_number),new RightSide(sign,sign_1),new RightSide(idT),new RightSide(stringT));
    }
    
    
    public static void produceConstantdef(){
        constant_definition.addRightSide(new RightSide(idT,igualT,constant));
    }
    
    
    public static void produceScalarType(){
        scalar_type.addRightSide(new RightSide(abreparT,idT,new Sequence(virgulaT,idT),fechaparT));
        
    }
    
    public static void produceIndexType(){
        index_type.addRightSide(new RightSide(scalar_type),new RightSide(unsigned_number,pontopontoT,constant),new RightSide(sign,sign_1,pontopontoT,constant),new RightSide(idT,type1),new RightSide(stringT,pontopontoT,constant));
    }
    
    
    public static void produceProgram(){
        program.addRightSide(new RightSide(program_heading,block,pontoT));
    }
    
    public static void producePH(){
        program_heading.addRightSide(new RightSide(programT,idT,abreparT,idT,new Sequence(pontovirgulaT,idT),fechaparT,pontovirgulaT));
    }

    public static void produceBlock(){
        block.addRightSide(new RightSide(label_declaration_part,constant_definition_part,Grammar.type_definition_part,Grammar.variable_declaration_part,Grammar.procedure_and_function_declaration_part,Grammar.statement_part));
    }
    
    public static void produceLabelDecl(){
        Grammar.label_declaration_part.addRightSide(new RightSide(labelT,numintT,new Sequence(virgulaT,numintT),pontovirgulaT),new RightSide(Grammar.empty));
    }
    
    public static void produceConstantDefinitionP(){
        Grammar.constant_definition_part.addRightSide(new RightSide(constT,constant_definition,new Sequence(pontovirgulaT,constant_definition,pontovirgulaT)),new RightSide(empty));
    }
    
    public static void produceTypeDefPart(){
        Grammar.type_definition_part.addRightSide(new RightSide(typeT,type_definition,new Sequence(pontovirgulaT,type_definition),pontovirgulaT),new RightSide(empty));
    }
    
    public static void produceTypeDef(){
        type_definition.addRightSide(new RightSide(idT,igualT,type));
    }
    
    public static void produceType(){
        type.addRightSide(new RightSide(scalar_type),new RightSide(unsigned_number,pontopontoT,constant),new RightSide(sign,sign_1,pontopontoT,constant),new RightSide(idT,type1),new RightSide(stringT,pontopontoT,constant),new RightSide(structured_type),new RightSide(empty));     
    }
    
    public static void produceType1(){
        type1.addRightSide(new RightSide(Grammar.pontopontoT,constant),new RightSide(Grammar.empty));
    }
    
    public static void produceStructuredType(){
        Grammar.structured_type.addRightSide(new RightSide(array_type),new RightSide(record_type),new RightSide(set_type),new RightSide(file_type));
    }
    
    public static void produceArrayType(){
        array_type.addRightSide(new RightSide(arrayT,abreretT,index_type,new Sequence(virgulaT,index_type),fecharetT,ofT,type));
    }
    
    public static void produceRecordType(){
        record_type.addRightSide(new RightSide(recordT,field_list,endT));
        
    }
    
    public static void produceFieldList(){
        field_list.addRightSide(new RightSide(fixed_part,fixed_part_1),new RightSide(variant_part));
    }
    
    public static void produceFixedPart1(){
        fixed_part_1.addRightSide(new RightSide(pontovirgulaT,variant_part),new RightSide(empty));
    }
    
    public static void produceFixedPart(){
        fixed_part.addRightSide(new RightSide(record_section,new Sequence(pontovirgulaT,record_section)));
    }
    
    public static void produceRecordSection(){
        record_section.addRightSide(new RightSide(idT,new Sequence(virgulaT,idT),pontovirgulaT,type),new RightSide(empty));
    }
    
    public static void produceVariantType(){
        variant_type.addRightSide(new RightSide(caseT,tag_field,idT,ofT,variant,new Sequence(pontovirgulaT,variant)));
    }
    
    public static void produceTagField(){
        tag_field.addRightSide(new RightSide(idT,doispontosT),new RightSide(empty));
    }
    
    public static void produceVariant(){
        variant.addRightSide(new RightSide(Grammar.case_label_list,doispontosT,abreparT,field_list,fechaparT),new RightSide(empty));
    }
    
    public static void produceCaseLabelList(){
        Grammar.case_label_list.addRightSide(new RightSide(constant,new Sequence(virgulaT,constant)));
    }
    
    public static void produceSetType(){
        set_type.addRightSide(new RightSide(setT,ofT,base_type));
    }
    
    public static void ProducebaseType(){
        base_type.addRightSide(new RightSide(scalar_type),new RightSide(unsigned_number,pontopontoT,constant),new RightSide(sign,sign_1,pontopontoT,constant),new RightSide(idT,type1),new RightSide(stringT,pontopontoT,constant));
    }
    
    public static void produceFileType(){
        file_type.addRightSide(new RightSide(fileT,ofT,type));
    }
    
    public static void produceVarDeclPart(){
        Grammar.variable_declaration_part.addRightSide(new RightSide(varT,Grammar.variable_declaration,new Sequence(pontovirgulaT,Grammar.variable_declaration),pontovirgulaT),new RightSide(Grammar.empty));
    }
    
    public static void produceVarDeclaration(){
        Grammar.variable_declaration.addRightSide(new RightSide(idT,new Sequence(virgulaT,idT),atribT,type));
    }
    
    public static void produceProcAndFuncDeclPart(){
        Grammar.procedure_and_function_declaration_part.addRightSide(new RightSide(new Sequence(Grammar.procedure_or_function_declaration,pontovirgulaT)));
    }
    
    public static void produceProcOrFuncDeclPart(){
        Grammar.procedure_or_function_declaration.addRightSide(new RightSide(Grammar.procedure_declaration),new RightSide(Grammar.function_declaration));
    }
    
    public static void produceProcDecl(){
        Grammar.procedure_declaration.addRightSide(new RightSide(Grammar.procedure_heading,block));
    }
    
    public static void produceProcHeading(){
        Grammar.procedure_heading.addRightSide(new RightSide(procedureT,idT,Grammar.procedure_heading_1));
    }
    
    public static void produceProcHeading1(){
        Grammar.procedure_heading_1.addRightSide(new RightSide(pontovirgulaT),new RightSide(abreparT,Grammar.formal_parameter_section,new Sequence(pontovirgulaT,Grammar.formal_parameter_section),fechaparT,doispontosT,type,pontovirgulaT));
    }
    
    public static void produceFormalParamSection(){
        Grammar.formal_parameter_section.addRightSide(new RightSide(parameter_group),new RightSide(varT,Grammar.parameter_group),new RightSide(functionT,Grammar.parameter_group),new RightSide(procedureT,idT,new Sequence(virgulaT,idT)));
    }
    
    public static void produceParameterGroup(){
        Grammar.parameter_group.addRightSide(new RightSide(idT,new Sequence(virgulaT,idT),doispontosT,type));
    }
    
    public static void produceFunctionDecl(){
        Grammar.function_declaration.addRightSide(new RightSide(Grammar.function_heading,block));
    }
    
    public static void produceFunctionHead(){
        Grammar.function_heading.addRightSide(new RightSide(functionT,idT,Grammar.function_heading_1));
    }
    
    public static void produceFunctionHead1(){
        Grammar.function_heading_1.addRightSide(new RightSide(doispontosT,result_type,pontovirgulaT),new RightSide(abreparT,Grammar.formal_parameter_section,new Sequence(pontovirgulaT,Grammar.formal_parameter_section),fechaparT,doispontosT,type,pontovirgulaT));
    }
    
    public static void produceStatementPart(){
        Grammar.statement_part.addRightSide(new RightSide(Grammar.compound_statement));
    }
    
    public static void produceStatement(){
        Grammar.statement.addRightSide(new RightSide(Grammar.unlabelled_statement),new RightSide(numintT,doispontosT,Grammar.unlabelled_statement));
    }
    
    public static void unlabelledStatement(){
        Grammar.unlabelled_statement.addRightSide(new RightSide(simple_statement),new RightSide(structured_statement));
    }
    
    public static void produceSimpleStmt(){
        Grammar.simple_statement.addRightSide(new RightSide(idT,Grammar.simple_statement_1),new RightSide(Grammar.go_to_statement), new RightSide(empty));
    }
    
    public static void produceSimpleStmt1(){
        Grammar.simple_statement_1.addRightSide(new RightSide(Grammar.variable_2,atribT,expression),new RightSide(Grammar.function_designator_1));
    }
    
    public static void produceAssignStmt(){
        Grammar.assignment_statement.addRightSide(new RightSide(idT,variable_2,atribT,expression));
    }
    
    
    
    public static void produceVariable(){
        variable.addRightSide(new RightSide(idT,variable_2));
    }
    
    public static void produceVariable2(){
        variable_2.addRightSide(new RightSide(array_variable,variable_2),new RightSide(record_variable,variable_2),new RightSide(empty));
    }
    
    public static void produceRecordVariable(){
        record_variable.addRightSide(new RightSide(pontoT,idT));
    }
    
    public static void produceArrayVariable(){
        array_variable.addRightSide(new RightSide(abreretT,expression, new Sequence(virgulaT,expression),fecharetT));
    }
    
    public static void produceExpression(){
        expression.addRightSide(new RightSide(simple_expression,expression_2));
    }
    
    public static void produceExpression2(){
        expression_2.addRightSide(new RightSide(relational_operator,simple_expression), new RightSide(empty));
    }
    
    public static void produceRelationalOperator(){
        relational_operator.addRightSide(new RightSide(igualT), new RightSide(diferenteT), new RightSide(menorT), new RightSide(menorigualT), new RightSide(maiorigualT), new RightSide(maiorT), new RightSide(inT));
    }
    
    public static void produceSimpleExpression(){
        simple_expression.addRightSide(new RightSide(term,Grammar.simple_expression_1), new RightSide(sign,term,Grammar.simple_expression_1));
    }
    
    public static void produceSimpleExpression1(){
        simple_expression_1.addRightSide(new RightSide(Grammar.adding_operator,Grammar.term,Grammar.simple_expression_1),new RightSide(Grammar.empty));
    }
    
    public static void produceAddingOperator(){
        adding_operator.addRightSide(new RightSide(maisT), new RightSide(menosT), new RightSide(orT));
    }
    
    public static void produceTerm(){
        term.addRightSide(new RightSide(factor, term_1));
    }
    
    public static void produceTerm1(){
        term_1.addRightSide(new RightSide(multiplying_operator, factor, term_1), new RightSide(empty));
    }
    
    public static void produceMultiplyingOperator(){
        multiplying_operator.addRightSide(new RightSide(vezesT), new RightSide(divisaoT), new RightSide(divT), new RightSide(modT), new RightSide(andT));
    }
    
    public static void produceFactor(){
        factor.addRightSide(new RightSide(idT, factor_2), new RightSide(unsigned_constant), new RightSide(abreparT,expression,fechaparT), new RightSide(set), new RightSide(notT, factor));
    }
    
    public static void produceFactor2(){
        factor_2.addRightSide(new RightSide(variable_2, factor_3), new RightSide(function_designator_1), new RightSide(empty));
    }
    
    public static void produceFactor3(){
        factor_3.addRightSide(new RightSide(array_variable), new RightSide(record_variable), new RightSide(empty));
    }
    
    public static void produceUnsignedConstant(){
        unsigned_constant.addRightSide(new RightSide(unsigned_number), new RightSide(stringT), new RightSide(nilT) );
    }
    
    public static void produceFunctionDesignator(){
        function_designator_.addRightSide(new RightSide(idT, function_designator_1));
    }
    
    public static void produceFunctionDesignator1(){
        function_designator_1.addRightSide(new RightSide(abreparT,actual_parameter, new Sequence(virgulaT, actual_parameter),fechaparT), new RightSide(empty));
    }
    
    public static void produceSet(){
        set.addRightSide(new RightSide(Grammar.abreretT,element_list,Grammar.fecharetT));
    }
    
    public static void produceElementList(){
        element_list.addRightSide(new RightSide(element, new Sequence(virgulaT,element)));
    }
    
    public static void produceElement(){
        element.addRightSide(new RightSide(expression, element_1));
    }
    
    public static void produceElement_1(){
        element_1.addRightSide(new RightSide(pontopontoT,expression), new RightSide(empty));
    }
    
    public static void produceProcedureStatement(){
        procedure_statement.addRightSide(new RightSide(idT, function_designator_1));
    }
    
     public static void produceActualParameter(){
        actual_parameter.addRightSide(new RightSide(expression), new RightSide(unsigned_constant), new RightSide(idT, factor_2));
    }
    
    public static void produceStructuredStatement(){
        structured_statement.addRightSide(new RightSide(compound_statement), new RightSide(conditional_statement), new RightSide(repetitive_statement), new RightSide(with_statement));
    }
    
    public static void produceCompoundStatement(){
        compound_statement.addRightSide(new RightSide(beginT, statement, new Sequence(pontovirgulaT, statement), endT, pontovirgulaT));
    }
    
    public static void produceConditionalStatement(){
        conditional_statement.addRightSide(new RightSide(if_statement), new RightSide(case_statement));
    }
    
    public static void produceIfStatement(){
        if_statement.addRightSide(new RightSide(ifT, expression, thenT, statement, if_statement_2));
    }
    
    public static void produceIfStatement2(){
        if_statement_2.addRightSide(new RightSide(elseT,statement), new RightSide(empty));
    }
    
    public static void produceCaseStatement(){
        case_statement.addRightSide(new RightSide(caseT, expression, ofT, case_list_element, new Sequence(pontovirgulaT,case_list_element),endT));
    }
    
    public static void produceCaseListElement(){
        case_list_element.addRightSide(new RightSide(case_label_list, pontoT, statement), new RightSide(empty));
    }
    
    
    public static void produceRepetitiveStatement(){
        repetitive_statement.addRightSide(new RightSide(while_statement), new RightSide(repeat_statement), new RightSide(for_statement));
    }
    
    public static void produceWhileStatement(){
        while_statement.addRightSide(new RightSide(whileT, expression, doT, statement));
    }
    
    public static void produceRepeatStatement(){
        repeat_statement.addRightSide(new RightSide(repeatT, statement, new Sequence(pontovirgulaT, statement), untilT, expression));
    }
    
    public static void produceForStatement(){
        for_statement.addRightSide(new RightSide(forT, idT, atribT, for_list, doT, statement));
    }
    
    public static void produceForList(){
        for_list.addRightSide(new RightSide(expression, for_list_1));
    }
    
    public static void produceForList1(){
        for_list_1.addRightSide(new RightSide(toT, expression), new RightSide(downtoT, expression));
    }
    
    
    public static void produceWithStatement(){
        with_statement.addRightSide(new RightSide(withT, record_variable_list, doT, statement));
    }
    
    public static void produceRecordVaribleList(){
        record_variable_list.addRightSide(new RightSide(variable, new Sequence(virgulaT, variable)));
    }
    
    
    public static void initGrammar(){
        produceProgram();
        producePH();
        produceBlock();
        produceLabelDecl();
        produceConstantDefinitionP();
        produceTypeDefPart();
        produceTypeDef();
        produceType();
        produceType1();
        produceStructuredType();
        produceArrayType();
        produceRecordType();
        produceFieldList();
        produceFixedPart1();
        produceFixedPart();
        produceRecordSection();
        produceVariantType();
        produceTagField();
        produceVariant();
        produceCaseLabelList();
        produceSetType();
        ProducebaseType();
        produceFileType();
        produceVarDeclPart();
        produceVarDeclaration();
        produceProcAndFuncDeclPart();
        produceProcOrFuncDeclPart();
        produceProcDecl();
        produceProcHeading();
        produceProcHeading1();
        produceFunctionHead();
        produceFormalParamSection();
        produceParameterGroup();
        produceFunctionDecl();
        produceFunctionHead1();
        produceStatementPart();
        produceStatement();
        unlabelledStatement();
        produceSimpleStmt();
        produceSimpleStmt1();
        produceAssignStmt();
        produceVariable();
        produceVariable2();
        produceRecordVariable();
        produceArrayVariable();
        produceArrayVariable();
        produceExpression();
        produceExpression2();
        produceRelationalOperator();
        produceSimpleExpression();
        produceSimpleExpression1();
        produceAddingOperator();
        produceTerm();
        produceTerm1();
        produceMultiplyingOperator();
        produceFactor();
        produceFactor2();
        produceFactor3();
        produceUnsignedConstant();
        produceFunctionDesignator();
        produceFunctionDesignator1();
        produceSet();
        produceElementList();
        produceElement();
        produceElement_1();
        produceProcedureStatement();
        produceActualParameter();
        produceStructuredStatement();
        produceCompoundStatement();
        produceConditionalStatement();
        produceIfStatement();
        produceIfStatement2();
        produceCaseStatement();
        produceCaseListElement();
        produceCaseLabelList();
        produceRepetitiveStatement();
        produceWhileStatement();
        produceRepeatStatement();
        produceForStatement();
        produceForList();
        produceForList1();
        produceWithStatement();
        produceRecordVaribleList();
        produceSign();
        produceUnsignedNumber();
        produceGoToStatement();
        produceSign1();
        produceConstant();
        produceConstantdef();
        produceScalarType();
        produceIndexType();
    }
    
}
