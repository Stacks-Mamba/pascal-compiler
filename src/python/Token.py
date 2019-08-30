from enum import Enum
import re
import string


class TokenType(Enum):
    #All pascal operators
    OPERATORS ={ "+":"TOK_ADD","-":"TOK_SUB","*":"TOK_MUL",":=":"TOK_ATRIB",
       "/":"TOK_DIV","~":"TOK_BN","&":"TOK_BAND","|":"TOK_BOR","!":"TOK_BOR",
        "=":"TOK_EQ","<>":"TOK_NEQ","<":"TOK_LT","<=":"TOK_LTE",">":"TOK_GT",
        ">=":"TOK_GTE"}

    #All pascal delimiters
    DELIMITERS={"(":"TOK_LP",")":"TOK_RP","[":"TOK_LIB","]":"TOK_RIB",
    "{":"TOK_CBL","}":"TOK_CBR","(*":"TOK_PSL","*)":"TOK_PSR",",":"TOK_VIRG",
    ".":"TOK_PONTO",";":"TOK_PV",":":"TOK_DP","..":"TOK_ELIP","^":"TOK_CIRC"}

    #All pascal reserved words
    KEYWORDS = { "and":"TOK_AND","array":"TOK_ARRAY","begin":"TOK_BEGIN",
    "case":"TOK_CASE","const":"TOK_CONST","div":"TOK_DIV","do":"TOK_DO",
    "dow nto":"TOK_DOWNTO","else":"TOK_ELSE","file":"TOK_FILE",
    "for":"TOK_FOR","forward":"TOK_FORWARD","function":"TOK_FUNCTION",
    "goto":"TOK_GOTO","if":"TOK_IF","in":"TOK_IN",
    "label":"TOK_LABEL","main":"TOK_MAIN","mod":"TOK_MOD",
    "nil":"TOK_NIL","not":"TOK_NOT","of":"TOK_OF",
    "or":"TOK_OR","packed":"TOK_PACKED","procedure":"TOK_PROCEDURE",
    "program":"TOK_PROGRAM","record":"TOK_RECORD","repeat":"TOK_REPEAT",
    "set":"TOK_SET","thento":"TOK_THENTO","type":"TOK_TYPE",
    "until":"TOK_UNTIL","var":"TOK_VAR","while":"TOK_WHILE",
    "with":"TOK_WITH","define":"TOK_DEFINE","extern":"TOK_EXTERN",
    "external":"TOK_EXTERNAL","module":"TOK_MODULE","otherwise":"TOK_OTHERWISE",
    "private":"TOK_PRIVATE","public":"TOK_PUBLIC","static":"TOK_STATIC",
    "univ":"TOK_UNIV"}

    #Token for string
    TOKEN_STR = "TOK_STR"

    #Token for numbers
    TOKEN_NUM = "TOK_NUM"

    #Token for identifiers
    TOKEN_ID = "TOK_ID"


#Class that represents a token contains the value and the lexeme
class Token:
    def __init__(self,value,lexeme,line):
        self.value = value
        self.lexeme = lexeme
        self.line = line
