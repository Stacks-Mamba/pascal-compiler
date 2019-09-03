from DFA import DFA
from Token import TokenType,Token
import string
from Rules import Rules
import re
#Just a new comment
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
            self.buffer = line
            print(line[len(line)-1]=="\n")
            print(line)
            #Process the line for a token
            for char in self.buffer:
                if char not in string.whitespace:
                    lexeme += char
                else:
                    for regex in Rules.NUMBERS.value:
                        match = re.search(regex,lexeme)
                        if match != None:
                            print(match.string)
                            break
                    lexeme = ""
            self.line+=1
            lexeme = ""

lexer = Lexer()
lexer.add_src("source.txt")
lexer.getToken()
