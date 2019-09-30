
'''
Grammar for the aritmetic expression  language
E -> (E) E1 |- E E1|id E1 | INT E1
E1 -> + E E1 | * E E1| <empty>
'''
from Lexer import TokenStream

class Symbol:
    def __init__(self,name):
        self.name = name

    def checkSymbol(self,token):
        pass

    def __str__(self):
        return self.name

    @staticmethod
    def error(tokenStream,s):
        print("Something broke on line: {}\nExpected {}".format(tokenStream.current_token.line,s))


class Terminal(Symbol):
    EMPTY = "EMPTY_TOKEN"
    #Token that represents this non t
    def __init__(self,name,token):
        super().__init__(name)
        self.token = token

    def checkSymbol(self,tokenStream):
        token = tokenStream.current_token.value
        if self.token == Terminal.EMPTY:
            print(token)
            return True
        elif self.token == token:
            print(token)
            return True
        elif TokenStream.EOS == token:
            print(token)
            return True
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
        return str(self.symbols)


'''Class that represents a Non Terminal symbols, that appear on
both side of a production rule'''

class NonTerminal(Symbol):

    def __init__(self,name,*derivations):
        super().__init__(name)
        self.derivations = list(derivations)

    def addDerivation(self,derivation):
        self.derivations.append(derivation)

    #Function to check a none terminal
    def checkSymbol(self,tokenStream):
        for d in self.derivations:
            if d.testDerivation(tokenStream):
                result = d.derive(tokenStream)
                return result
        return False
