from DFA import DFA
from Token import TokenType,Token
import string
from Rules import Rules
#The lexer class
class Lexer:
    def __init__(self):
        self.line = 0
        self.src_file = None
        self.buffer = None
        self.fp = None
        token_list = []

    #Add and open source file
    def add_src(self,file):
        self.src_file = file
        self.fp = open(file,"r")

    #Function used for getting tokens and adding them to the symbol
    def getToken(self):
        lexeme = ""
        for line in self.fp:
            self.buffer = self.fp.readline()
            #Process the line for a token
            match = re.search(Rules.NUMBERS.value,self.buffer)
            print(match)
            self.line+=1

lexer = Lexer()
lexer.add_src("source.txt")
lexer.getToken()
