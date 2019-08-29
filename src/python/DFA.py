#Hello i am lexer V2
from enum import Enum
import re
import string

#Transition table for identifier DFA
identifier = ({
(0,"(_|[A-Za-z])"):1,(1,"(_|[A-Za-z]|[0-9])*"):1
},[1])

#Transition table for aritmetic operators DFA
aritmetic_op = ({
(0,"\\+"):1,(0,"-"):4,(0,"\\*"):3,(0,"="):2,(0,"/"):5,
(1,"="):2,(3,"="):2,(3,"\\*"):6,(4,"="):2,(5,"="):2
},[1,2,3,4,5,6])


class Rule(Enum):
    pass

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

dfa = DFA(7,aritmetic_op[1],aritmetic_op[0])
string = input("Input string > ")
result = dfa.read_string(string)
print(result)
