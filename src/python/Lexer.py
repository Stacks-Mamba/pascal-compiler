import string
import re
from Token import TokenType,Token
#Just a new comment
#The lexer class
ARIT_GOL=({(0,r"[+\-*/()]"):5,(0,r"[a-zA-z_]"):1,(0,r"\d"):3,
(1,r"[a-zA-z_0-9]"):1,(1,r"[^a-zA-z_0-9]"):2,
(3,r"\d"):3,(3,r"\D"):4},[2,4,5])



class Lexer:

    tokens = [TokenType.DELIMETERS_ARIT.value,
    TokenType.IDENTIFIER_ARIT.value,TokenType.OPERATORS_ARIT.value,
    TokenType.TOKEN_NUM_ARIT.value]

    def __init__(self,src):
        self.line = 0
        self.col = -1
        self.buffer = None
        self.buffer_size = 0
        self.dfa = DFA(6,ARIT_GOL[1],ARIT_GOL[0])
        self.fp = open(src,"r")
        token_list = []

    def getInput(self):
        self.buffer = self.fp.readline()
        self.buffer_size = len(buffer)
        self.line+=1
        self.col = 0
    #Function used for getting tokens and adding them to the symbol
    def getToken(self):
        #If line over, get new line
        if buffer_size == col+1:
            self.getInput()
        #Current lexeme
        lexeme =""
        ''' Get characters from the buffer while
        dfa is not in a final state'''
        while True:
            char = buffer[self.col]
            dfa.transition(char)
            if dfa.isFinalState():
                break
            lexeme.append(char)
            self.col+=1
        #Return the match
        for type in tokens:
            for regex in type:
                exp = re.compile(regex)
                if exp.match(lexeme):
                    return Token(type[regex],lexeme,self.line)







lexer = Lexer()
lexer.add_src("source.txt")
lexer.getToken()
