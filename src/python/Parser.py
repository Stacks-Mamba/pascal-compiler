from Symbol import *
from Lexer import Lexer,TokenStream

class Parser:
    ##Defining the grammar

    def __init__(self,lexer):
        self.tokenStream = TokenStream(lexer)

    def parseProgram(self):
