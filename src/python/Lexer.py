import string
import re
from Token import TokenType,Token
from DFA import DFA



#The lexer class
ARIT_GOL=({(0,r"[+\-*/()]"):5,(0,r"[a-zA-z_]"):1,(0,r"\d"):3,
(1,r"[a-zA-z_0-9]"):1,(1,r"[^a-zA-z_0-9]"):2,
(3,r"\d"):3,(3,r"\D"):4,(5,r"\w|\s"):6},[2,4,6])

class Lexer:

    tokens = [TokenType.DELIMETERS_ARIT.value,
    TokenType.IDENTIFIER_ARIT.value,TokenType.OPERATORS_ARIT.value,
    TokenType.TOKEN_NUM_ARIT.value]

    def __init__(self,src):
        self.line = 1
        self.col = 0
        self.fp = open(src,"r")
        self.buffer = self.fp.readline()
        self.buffer_size = len(self.buffer)
        self.dfa = DFA(7,ARIT_GOL[1],ARIT_GOL[0])
        token_list = []

    def hasNextTok(self):
        return True if self.buffer!="" else False

    def getInput(self):
        self.buffer = self.fp.readline()
        if self.buffer != "" :
            self.buffer_size = len(self.buffer)
            self.line+=1
            self.col = 0
    #Function used for getting tokens and adding them to the symbol
    def getToken(self):
        self.dfa.current_state = 0
        #If line over, get new line
        if self.buffer_size == self.col+1:
            self.getInput()
            if not self.hasNextTok():
                return None
        #Current lexeme
        lexeme =""
        ''' Get characters from the buffer while
        dfa is not in a final state'''
        while True:
            char = self.buffer[self.col]
            #print("Line {0}, col {1} : {2}".format(self.line,self.col,char))
            self.dfa.transition(char)
            if self.dfa.isFinalState():
                break
            lexeme += char
            self.col += 1
        #print(lexeme)
        #Return the match by checking all tokA
        for type in Lexer.tokens:
            for regex in type:
                exp = re.compile(regex)
                if exp.match(lexeme):
                    return Token(type[regex],lexeme,self.line)
        #if it gets here
        Exception()

class TokenStream:
    EOS = "END_OF_STREAM"
    def __init__(self,lexer):
        self.lexer = lexer

    def getNextToken(self):
        nextToken = self.lexer.getToken()
        return nextToken if nextToken != None else EOS



def main():
    lexer = Lexer("src.txt")
    token = ''
    while token != None:
        token = lexer.getToken()
        print(token)

if __name__=="__main__":
    main()
