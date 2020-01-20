#ifndef __POOLT____
#define __POOLT____ 

#include <string>
#include <iostream>

struct pool_t {
    int id;
    std::string name;
    float length;
    float widtch;
    float depth;
};

inline bool operator==(const pool_t &a, const pool_t &b) {
    return (a.id == b.id) && (a.name == b.name);
}

inline std::ostream &operator<<(std::ostream &out, const person_t &p) {
    out << "{" << p.id << ", " << p.name << "}";
    return out;
}

#endif
