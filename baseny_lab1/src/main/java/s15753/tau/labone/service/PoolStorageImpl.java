package s15753.tau.labone.service;

import java.util.*;
import s15753.tau.labone.domain.*;

public class PoolStorageImpl {
    HashMap<Integer,Pool> storage;

    public PoolStorageImpl(){
        this.storage = new HashMap<Integer,Pool>();
    }

    public void create(Pool pool) throws Exception {
        if(this.storage.containsKey(pool.getId()))
        {
            throw new Exception("Id already added");
        }
        this.storage.put(pool.getId(), pool);
    }

    public Map<Integer,Pool> readAll() {
        return this.storage;
    }

    public Map<Integer,Pool> read(int id) throws Exception {
        if(!this.storage.containsKey(id)
        {
            throw new Exception("Id not found");
        }
        return this.storage.get(id));
    }

    public void update(int id, Double length, Double width, Double depth) throws Exception {
        if(!this.storage.containsKey(id)
        {
            throw new Exception("Id not found");
        }
        Pool updatedPool = this.storage.get(id));
        updatedPool.setLength(length);
        updatedPool.setWidth(width);
        updatedPool.setDepth(depth);

    }

}