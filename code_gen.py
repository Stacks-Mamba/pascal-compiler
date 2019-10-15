
def main():
    output = open("code.txt","w")
    with open("string_keywords.txt","r") as f:
        for line in f:
            line1 = line.strip()
            output.write("case \"{0}\":\n    token = new Token(Tokens.{1},lexema,numeroLinha);\n    break;\n".format(line1.lower(),line1))
    output.close()


main()
