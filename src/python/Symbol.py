
'''
Grammar for the aritmetic expression  language
E -> (E) E1 |-E E1|id E1 | INT E1
E1 -> +E E1 | *E | <empty>
'''





class Symbol:
    def __init__(self,name):
        self.name = name

    def checkSymbol(self,token):
        pass


    @staticmethod
    def error():
        pass


class Terminal(Symbol):
    EMPTY = "EMPTY_TOKEN"
    #Token that represents this non t
    def __init__(self,name,token):
        super().__init__(name)
        self.token = token

    def checkSymbol(self,token):
        if self.token == EMPTY:
            return True
        elif self.token == token:
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

    def testDerivation(self,token):
        return self.symbols[0].checkSymbol(token)

    def derive(self,token):
        for s in self.symbols:
            result = s.checkSymbol(token)
            if not result:
                return False
        return True



'''Class that represents a Non Terminal symbols, that appear on
both side of a production rule'''

class NonTerminal(Symbol):

    def __init__(self,name,*derivations):
        super().__init__(name)
        self.derivations = list(derivations)

    def addDerivation(self,derivation):
        self.derivations.append(derivation)

    #Function to check a none terminal
    def checkSymbol(self,token):
        result = False
        for d in self.derivations:
            if d.testDerivation(token):
                result = result and d.derive(token)
        return result
