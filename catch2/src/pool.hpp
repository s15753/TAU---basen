#ifndef HELLO_CATCH2_CMAKE_POOL_HPP
#define HELLO_CATCH2_CMAKE_POOL_HPP


#include <string>

class Pool {

private:
    int id;
    std::string name;
    float length;
    float width;
    float depth;
public:
    Pool(int, std::string, float, float, float);
    Pool();
    bool equals(const Pool&);

    int getById() const;

    const std::string &getName() const;

    float getLength() const;
    float getWidth() const;
    float getDepth() const;

};


#endif //HELLO_CATCH2_CMAKE_POOL_HPP


