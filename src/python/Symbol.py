from Lexer import TokenStream

'''
Grammar for the aritmetic expression  language
E -> (E) E1 |- E E1|id E1 | INT E1
E1 -> + E E1 | * E E1| <empty>
'''

class Symbol:
    def __init__(self,descrip):
        self.descrip = descrip

    def checkSymbol(self,token):
        pass

    def __str__(self):
        return self.descrip

    @staticmethod
    def error(tokenStream,s):
        print("Something broke on line: {}\nExpected {}".format(tokenStream.current_token.line,s))


class Terminal(Symbol):
    EMPTY = "EMPTY_TOKEN"
    #Token that represents this non t
    def __init__(self,descrip,token):
        super().__init__(descrip)
        self.token = token

    def checkSymbol(self,tokenStream):
        token = tokenStream.current_token
        if self.token == Terminal.EMPTY:
            return True
        elif self.token == token.value:
            return True
        elif TokenStream.EOS == token.value:
            return False
        return False




''' Class that represents the right side of a production rules
which are strings of terminals and Nonterminals
'''

class Derivation:

    def __init__(self,*symbols):
        self.symbols = list(symbols)

    def addSymbol(self,symbol):
        self.symbols.append(symbol)

    def testDerivation(self,tokenStream):
        return self.symbols[0].checkSymbol(tokenStream)

    def derive(self,tokenStream):
        for s in self.symbols:
            result = s.checkSymbol(tokenStream)
            if not result:
                Symbol.error(tokenStream,s)
                return False
            tokenStream.getNextToken()
        return True

    def __str__(self):
        return " ".join(self.symbols)

'''Class that represents a Non Terminal symbols, that appear on
both side of a production rule'''

class NonTerminal(Symbol):

    def __init__(self,descrip,*derivations):
        super().__init__(descrip)
        self.derivations = list(derivations)
        self.emptyProduction = False

    def addDerivation(self,derivation):
        self.derivations.append(derivation)

    #Function to check a none terminal
    def checkSymbol(self,tokenStream):
        print(self)
        for d in self.derivations:
            if d.testDerivation(tokenStream):
                result = d.derive(tokenStream)
        return result
