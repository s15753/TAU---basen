import argparse

def shape_recognizer(parms):
    if (parms[0] > 0) and (parms[1] > 0) and (parms[2] > 0) and (parms[3] == 0):
        a, b, c = parms[:3]

        if (a + b <= c) or (a + c <= b) or (b + c <= a):
            print("shape_recognizer.py: error: Z tych boków nie da się zbudować trójkąta")
            exit()

        if(a==b) and (a==c):
            print("trójkąt równoboczny")
        elif(a==b) or (a==c) or (b==c):
            print("trójkąt równoramienny")
        else:
            print("trójkąt różnoramienny")

    elif (parms[0] > 0) and (parms[1] > 0) and (parms[2] > 0) and (parms[3] > 0):
        a, b, c, d = parms

        if (a + b + c <= d) or (a + c + d <= b) or (a + b + d <= c) or (b + c +d <= a):
            print("shape_recognizer.py: error: Z tych boków nie da się zbudować czworoboka")
            exit()

        if (a == b == c == d):
            print("kwadrat")
        elif ((a == b) and (c == d)) or ((a == d) and (c == b)) or ((a == c) and (b == d)):
            print("prostokąt")
        else:
            print("czworobok")

    else:
        print("shape_recognizer.py: error: Błędna długość boków. Przynajmniej 3 boki muszą mieć długość > 0")
        exit()

def build_arg_parser():
    parser = argparse.ArgumentParser(description='Zgaduje figurę po ilości i długości boków')
    parser.add_argument('-a', '--a', type=int, help='Pierwszy bok')
    parser.add_argument('-b', '--b', type=int, help='Drugi bok')
    parser.add_argument('-c', '--c', type=int, help='Trzeci bok')
    parser.add_argument('-d', '--d', type=int, default = 0, help='Czwarty bok')
    parms = parser.parse_args()

    if(parms.a is None) or (parms.b is None) or (parms.c is None):
        print("shape_recognizer.py: error: Musisz podać przynajmniej 3 boki")
        exit()
    sides = [value for key, value in vars(parms).items()]
    sides.sort(reverse=True)
    return sides

if __name__ == '__main__':
    shape_recognizer(build_arg_parser())