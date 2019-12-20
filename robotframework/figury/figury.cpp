#include <iostream>
#include <string>

/* Twórca: Damian Szwichtenberg, s13456
 * kompilacja g++ figury.cpp -o program
 * przykłady użycia:
 * ./program 2 2 2;   przewidywany output: trójkąt równoboczny
 * ./program 3 3 3 3; przewidywany output: kwadrat
*/

std::string get_figure_type(int a, int b, int c);
std::string get_figure_type(int a, int b, int c, int d);

int main(int argc, char* argv[]) {
    if (argc == 4) {
        try {
            int a = std::stoi(argv[1]); 
            int b = std::stoi(argv[2]); 
            int c = std::stoi(argv[3]);
            std::cout << get_figure_type(a, b, c) << std::endl;
        }
        catch (const std::invalid_argument e) {
            std::cout << "ERROR:nieprawidlowy_argument: Podales argument ktory nie jest liczba - nalezy podac liczbe calkowita" << std::endl;
        }
    }
    else if (argc == 5) {
        try {
            int a = std::stoi(argv[1]); 
            int b = std::stoi(argv[2]); 
            int c = std::stoi(argv[3]);
            int d = std::stoi(argv[4]);
            std::cout << get_figure_type(a, b, c, d) << std::endl;
        }
        catch (const std::invalid_argument e) {
            std::cout << "ERROR:nieprawidlowy_argument: Podales argument ktory nie jest liczba - nalezy podac liczbe calkowita" << std::endl;
        }
        
    }
    else {
        std::cout << "ERROR:nieprawidlowa_liczba_argumentow: Podales za duzo argumentow - podaj 3 lub 4 dlugosci bokow" << std::endl;
    }
}

std::string get_figure_type(int a, int b, int c) {
    if (a + b < c ||
        a + c < b ||
        b + c < a)
        return "ERROR:nieprawidlowa_figura: Z podanych bokow nie da się złożyć trójkąta";
    else if (a == b && b == c)
        return "trójkąt równoboczny";
    else if (a != b &&
             a != c &&
             b != c)
        return "trójkąt różnoramienny";
    else
        return "trójkąt równoramienny";
}

std::string get_figure_type(int a, int b, int c, int d) {
    if (a == b &&
        b == c &&
        c == d)
        return "kwadrat";
    else if ((a == b && c == d) ||
             (a == c && b == d) ||
             (a == d && b == c))
        return "prostokąt";
    else if (a >= b + c + d ||
             b >= a + c + d ||
             c >= a + b + d ||
             d >= a + b + c)
        return "ERROR:nieprawidlowa_figura: Z podanych bokow nie da się złożyć czworokąt";
    else
        return "czworobok";
}
