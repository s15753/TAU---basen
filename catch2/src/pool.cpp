#include <utility>

#include "Pool.hpp"

Pool::Pool(int id, std::string name, float length, float width, float depth) {
    this->id = id;
    this->title = std::move(name);
    this->length = length;
    this->width = width;
    this->depth = depth;
}

bool Pool::equals(const Pool &secondPool) {
    return id == secondPool.id;
}

int Pool::getId() const {
    return id;
}

const std::string &Pool::getName() const {
    return name;
}

float Pool::getLength() const {
    return length;
}

float Pool::getWidth() const {
    return width;
}

float Pool::getDepth() const {
    return depth;
}

Pool::Pool() = default;

