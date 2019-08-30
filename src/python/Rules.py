import re
import string
from enum import Enum
from Token import Token

DIGITS = "[0-9]+"


class Rules(Enum):
    #Regular expressions for every type of token
    NUMBERS = '''{0}|{0}E{0}|{0}E(+|-){0}
                {0}.{0}|{0}.{0}E{0}|{0}.{0}E(+|-){0}'''.format(DIGITS)
