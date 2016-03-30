from random import randint

num = raw_input("How many processes?\n")

for i in range (0, int(num)):
    out = ""
    out += str(100+i)
    out += ","
    out += str(randint(0, 30))
    out += ","
    out += str(randint(i, i+3))
    out += ","
    out += str(randint(0, 10))
    print out
