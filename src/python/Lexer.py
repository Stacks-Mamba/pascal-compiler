#The lexer class 
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
