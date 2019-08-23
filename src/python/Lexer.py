#Hello i am lexer V2
from enum import Enum
import string


#GLOBAL VARS
token_list=[]




class TokenValue(Enum):
    OPERATOR = 1
    KEYWORD = 2
    IDENTIFIER = 3
    SEPARATOR = 4
    NUMBER = 5
    STRING = 6

class DFA:
    def __init__(self,num_states=2,final_states=[],table={}):
        self.states=[x for x in range(num_states)]
        self.final_states=final_states
        self.current_state=0
        self.trans_table=table

        def read_string(self,string):
            for c in string:
                self.transition(c)
                if self.current_state in self.final_states:
                    return "String accepted"
                else:
                    return "String rejected"
                    def transition(self,char):
                        key = (self.current_state,char)
                        if key in self.trans_table:
                            self.current_state = self.trans_table[key]


class RegExs(Enum):
    pass





class Token:
    def __init__(value,lexeme):
        self.value = value
        self.lexeme = lexeme





class Lexer:
    def __init__():
        self.line = 0
        self.col = 0
        self.src_file = None
        self.fp = None

    #Add and open source file
    def add_src(file):
        self.src_file = file
        self.fp = open(file,"r")

    #Function used for getting tokens and adding them to the symbol
    def getToken():
        pass



trans_table={
(0,">"):1,(0,"<"):2,(1,"="):3,
(2,"="):3}

t2={(0,"a"):1,(0,"b"):0,(0,"c"):0,
(1,"a"):2,(1,"b"):0,(1,"c"):0,
(2,"a"):2,(2,"b"):0,(2,"c"):0,
}
dfa = DFA(3,[2],t2)
string = input("Input string > ")
result = dfa.read_string(string)
print(result)
