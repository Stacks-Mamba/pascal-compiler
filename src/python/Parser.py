from Symbol import *
from Lexer import Lexer,TokenStream

##Defining the grammar
empty = Terminal("empty",Terminal.EMPTY)
integer = Terminal("int","TOK_NUM")
identifier = Terminal("id","TOK_ID")
minus = Terminal("aritmec1","TOK_SUB")
plus = Terminal("aritmec2","TOK_PLUS")
mult = Terminal("aritmec3","TOK_MUL")
rp = Terminal("rp","TOK_RP")
lp = Terminal("lp","TOK_LP")
E = NonTerminal("E")
E1 = NonTerminal("E1")

#DerivationsE
d1E = Derivation(lp,E,rp,E1)
d2E = Derivation(minus,E,E1)
d3E = Derivation(identifier,E1)
d4E = Derivation(integer,E1)

for d in [d1E,d2E,d3E,d4E]:
    E.addDerivation(d)

#DerivationsE1
d1E1 = Derivation(plus,E,E1)
d2E1 = Derivation(mult,E)
d3E1 = Derivation(empty)

for d in [d1E1,d2E1,d3E1]:
    E1.addDerivation(d)


class Parser:
    def __init__(self,lexer):
        self.tokenStream = TokenStream(lexer)

    def parseProgram(self):
        #Get first token
        self.tokenStream.getNextToken()
        #Start the parsing of the program
        E.checkSymbol(self.tokenStream)
