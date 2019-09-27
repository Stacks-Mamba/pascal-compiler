import re
import string
from enum import Enum
from Token import Token

DIGITS = "[0-9]+"


class Rules(Enum):
    #Regular expressions for every type of token
    numbers = r'\d+\.?\d+[Ee]?[+-]?\d+'
    identifier = r"[a-zA-z_][a-zA-Z_0-9]*"
    string_literal = r"'[a-zA-z_0-9 \t\n\r\f\v=\-+*\./|{}()<>!]*'"

source = '''123341221 1231331 122341.32123 123.211 0.03 0.09
712211312E34212 10E19 102E+112 10E-12 10.78E+12 11.78E-12'''

str = "i j k f1 j1 1array vector2 _vector _vector_ 'this is a string' 'another string' 'string with some weird stuff__' '<>sadaamoms!()' "


p = re.compile(Rules.identifier.value)
print(p)
print(p.findall(str))
