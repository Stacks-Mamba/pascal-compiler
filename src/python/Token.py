from enum import Enum
import re
import string



token_list=[]
class TokenType(Enum):
    OPERATORS ={ "+":"TOK_ADD","-":"TOK_SUB","*":"TOK_MUL",":=":"TOK_ATRIB",
       "/":"TOK_DIV","~":"TOK_BN","&":"TOK_BAND","|":"TOK_BOR","!":"TOK_BOR",
        "=":"TOK_EQ","<>":"TOK_NEQ","<":"TOK_LT","<=":"TOK_LTE",">":"TOK_GT",
        ">=":"TOK_GTE"}

    DELIMITERS={"(":"TOK_LP",")":"TOK_RP","[":"TOK_LIB","]":"TOK_RIB",
    "{":"TOK_CBL","}":"TOK_CBR","(*":"TOK_PSL","*)":"TOK_PSR",",":"TOK_VIRG",
    ".":"TOK_PONTO",";":"TOK_PV",":":"TOK_DP","..":"TOK_ELIP","^":"TOK_CIRC"}


    PRE_ID = {}




class Token:
    RESERVED_WORDS = ["and","array","begin","case","const","div","do"
                ,"downto","else","file","for","forward","function",
                "goto","if","in","label","main","mod","nil","not","of","or",
                "packed","procedure","program","record","repeat","set","then"
                "to","type","until","var","while","with","define","extern",
                "external","module","otherwise","private","public","static"
                "univ"]

    def __init__(value,lexeme):
        self.value = value
        self.lexeme = lexeme
