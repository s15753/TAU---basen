#ifndef __MY_DB_H___
#define __MY_DB_H___
#include "pool.hpp"
#include <list>
#include <map>

class Database {
    protected:
    std::map<int,pool_t> database;
    public:
    Database();
    std::list <pool_t> getAll();
    void insert(const pool_t &p);
    void remove(const int id);  
};

#endif
