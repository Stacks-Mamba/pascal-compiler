#Hello i am lexer V2
from enum import Enum
import re
import string


#GLOBAL VARS
token_list=[]
letter = string.ascii_letters
operators = ["+","-","*","/"]

#Transition table for identifier DFA
identifier = ({
(0,"(_|[A-Za-z])"):1,(1,"(_|[A-Za-z]|[0-9])*"):1
},[1])

#Transition table for aritmetic operators DFA
aritmetic_op = ({
(0,"\\+"):1,(0,"-"):4,(0,"\\*"):3,(0,"="):2,(0,"/"):5,
(1,"="):2,(3,"="):2,(3,"\\*"):6,(4,"="):2,(5,"="):2
},[1,2,3,4,5,6])

#Recognizing numbers
 #number_table


class TokenType(Enum):
    ARITOP = 1,
    KEYWORD = 2
    IDENTIFIER = 3
    SEPARATOR = 4
    NUMBER = 5
    STRING = 6
    RELOP = 7

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
        for key in self.trans_table:
            if key[0]==self.current_state:
                if re.match(key[1],char) is not None:
                    self.current_state = self.trans_table[key]


class Token:
    def __init__(value,lexeme):
        self.value = value
        self.lexeme = lexeme



class Lexer:
    def __init__(self):
        self.line = 0
        self.col = 0
        self.src_file = None
        self.buffer = None
        self.fp = None

    #Add and open source file
    def add_src(self,file):
        self.src_file = file
        self.fp = open(file,"r")

    #Function used for getting tokens and adding them to the symbol
    def getToken(self):
        #Get a line from the file
        self.buffer = self.fp.readline()
        self.line+=1
        #Process the line for a token




dfa = DFA(7,aritmetic_op[1],aritmetic_op[0])
string = input("Input string > ")
result = dfa.read_string(string)
print(result)
