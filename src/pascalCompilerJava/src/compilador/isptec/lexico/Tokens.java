/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.lexico;
/**
 *
 * @author hairt
 */
public enum Tokens {
    NUMINT,NUMREAL,DIVISAO,ID,EOF,ERRO,IGUAL,MENOR,DIFERENTE,MENORIGUAL,MAIOR,MAIORIGUAL,
    MAIS,MENOS,VEZES,PONTO,PONTOPONTO,DOISPONTOS,DOISPONTOSIGUAL,ABREPAR,
    ABREFECHAPAR,FECHAPAR,ABRERET,FECHARET,VIRGULA,BARRAN,PONTOVIRGULA,
    BARRA,TIL,ARROBA,CIFRAO,SUSTENIDO,MAISIGUAL,MENOSIGUAL,VEZESIGUAL,BARRAIGUAL,
    ABRECOMENTARIO,FECHACOMENTARIO,ABREPARPONTO,PONTOFECHAPAR,BARRABARRA,UNDER,TABULACAO,
    ABSOLUTE,ELSE,NIL,SET,AND,END,NOT,SHL,ARRAY,OBJECT,SHR,ASM,FOR,OF,STRING,INT,REAL,DOUBLE,CHAR,BOOL, BEGIN,FUNCTION,
    ON,THEN,BREAK,GOTO,OPERATOR,TO,CASE,IF,OR,TYPE,CONST,IMPLEMENTATION,PACKED,UNIT,
    CONSTRUCTOR,IN,PROCEDURE,UNTIL,CONTINUE,INHERITED,PROGRAM,USES,DESTRUCTOR,
    INLINE,RECORD,VAR,DIV,INTERFACE,REINTRODUCE,WHILE,DO,LABEL,REPEAT,WITH,
    DOWNTO,MOD,SELF,XOR,AS,CLASS,EXCEPT,EXPORTS,FINALIZATION,FINALLY,INITIALIZATION,
    IS,LIBRARY,OUT,PROPERTY,RAISE,THREADVAR,TRY,DISPOSE,FALSE,TRUE,EXIT,NEW,OTHERWISE,FILE;
    @Override
    public String toString(){
    switch(this){
        case FILE:
            return "palavra reservada 'file'";
        case PROPERTY:
            return "Identifier 'property'";
        case CONTINUE:
            return "Identifier 'continue'";
        case UNTIL:
            return "palavra reservada until";
        case ERRO:
            return "Token inválido";
        case EOF:
            return "Final Arquivo";
        case IGUAL:
            return "Operador '='";
        case DIVISAO:
            return "Operador '/'";
        case MENOR:
            return "Operador '<'";
        case MENORIGUAL:
            return "Operador '<='";
        case DIFERENTE:
            return "Operador '<>'";
        case MAIOR:
            return "Operador '>'";
        case MAIORIGUAL:
            return "Operador '>='";
        case MAIS:
            return "Operador '+'";
        case MENOS:
            return "Operador '-'";
        case VEZES:
            return "Operador '*'";
        case PONTO:
            return "Operador '.'";
        case PONTOPONTO:
            return "Operador '..'";
        case DOISPONTOS:
            return "Operador ':'";
        case ABREPAR:
            return "'('";
        case ABREFECHAPAR:
            return "'()'";
        case FECHAPAR:
            return "')'";
        case ABRERET:
            return "Operador '['";
        case FECHARET:
            return "Operador ']'";
        case VIRGULA:
            return "','";
        case BARRAN:
            return "Operador '\n'";
        case PONTOVIRGULA:
            return "';'";
        case BARRA:
            return "Operador '/'";
        case TIL:
            return "Operador '~'";
        case ARROBA:
            return "'@'";
        case CIFRAO:
            return "'$'";
        case SUSTENIDO:
            return "'#'";
        case MAISIGUAL:
            return "'+='";
        case MENOSIGUAL:
            return "'-='";
        case VEZESIGUAL:
            return "'*='";
        case BARRAIGUAL:
            return "'/='";
        case ABRECOMENTARIO:
            return "'(*'";
        case FECHACOMENTARIO:
            return "'*)'";
        case ABREPARPONTO:
            return "'(.'";
        case PONTOFECHAPAR:
            return "'.)'";
        case BARRABARRA:
            return "'//'";
        case UNDER:
            return "'_'";
        case TABULACAO:
            return "'\t'";
        case ID:
            return "identificador";
        case ABSOLUTE:
            return "identificador 'absolute'";
        case ELSE:
            return "palavra reservada 'else'";
        case NIL:
            return "palavra reservada 'nil'";
        case SET:
            return "palavra reservada 'set'";
        case AND:
            return "palavra reservada 'and'";
        case END:
            return "palavra reservada 'end'";
        case NOT:
            return "comando 'not'";
        case SHL:
            return "comando 'shl'";
        case ARRAY:
            return "palavra reservada 'array'";
        case OBJECT:
            return "comando 'object'";
        case SHR:
            return "comando 'shr'";
        case ASM:
            return "comando 'asm'";
        case FOR:
            return "palavra reservada 'for'";
        case OF:
            return "palavra reservada 'of'";
        case STRING:
            return "string";
        case INT:
            return "identificador 'integer'";
        case REAL:
            return "identificador 'real'";
        case DOUBLE:
            return "identificador 'double'";
        case CHAR:
            return "identificador 'char'";
        case BOOL:
            return "identificador 'boolean'";
        case CONST:
            return "palavra reservada 'const'";
        case BEGIN:
            return "palavra reservada 'begin'";
        case FUNCTION:
            return "palavra reservada 'function'";
        case ON:
            return "comando 'on'";
        case THEN:
            return "palavra reservada 'then'";
        case BREAK:
            return "comando 'break'";
        case GOTO:
            return "palavra reservada 'goto'";
        case OPERATOR:
            return "comando 'operator'";
        case TO:
            return "palavra reservada 'to'";
        case CASE:
            return "palavra reservada 'case'";
        case IF:
            return "palavra reservada 'if'";
        case OR:
             return "palavra reservada 'or'";
        case TYPE:
            return "palavra reservada 'type'";
        case IMPLEMENTATION:
            return "comando 'implementation'";
        case PACKED:
            return "comando 'packed'";
        case UNIT:
            return "comando 'unit'";
        case CONSTRUCTOR:
            return "comando 'constructor'";
        case IN:
            return "palavra reservada 'in'";
        case PROCEDURE:
            return "palavra reservada 'procedure'";
        case INHERITED:
            return "comando 'inherited'";
        case PROGRAM:
            return "palavra reservada 'program'";
        case USES:
            return "comando 'uses'";
        case DESTRUCTOR:
            return "comando 'destructor'";
        case INLINE:
            return "comando 'inline'";
        case RECORD:
            return "palavra reservada 'record'";
        case VAR:
            return "palavra reservada 'var'";
        case DIV:
            return "palavra reservada 'div'";
        case INTERFACE:
            return "comando 'interface'";
        case REINTRODUCE:
            return "comando 'reintroduce'";
        case WHILE:
            return "palavra reservada 'while'";
        case DO:
            return "palavra reservada 'do'";
        case LABEL:
            return "palavra reservada 'label'";
        case REPEAT:
            return "palavra reservada 'repeat'";
        case WITH:
            return "palavra reservada 'with'";
        case DOWNTO:
            return "palavra reservada 'downto'";
        case MOD:
            return "palavra reservada 'mod'";
        case SELF:
            return "comando 'self'";
        case XOR:
            return "comando 'xor'";
        case AS:
            return "comando 'as'";
        case CLASS:
            return "comando 'class'";
        case EXCEPT:
            return "comando 'except'";
        case EXPORTS:
            return "comando 'exports'";
        case FINALIZATION:
            return "comando 'finalization'";
        case FINALLY:
            return "comando 'finally'";
        case INITIALIZATION:
            return "comando 'initialization'";
        case IS:
            return "comando 'is'";
        case LIBRARY:
            return "comando 'library'";
        case OUT:
            return "comando 'out'";
        case RAISE:
            return "comando 'raise'";
        case THREADVAR:
            return "comando 'thereadvar'";
        case TRY:
            return "comando 'try'";
        case DISPOSE:
            return "comando 'dispose'";
        case FALSE:
            return "'false'";
        case TRUE:
            return "'true'";
        case EXIT:
            return "comando 'exit'";
        case NEW:
            return "comando 'new'";
        default:
            return " ";
    }
    }
}
