package s15753.tau.labone.service;

import java.util.*;
import s15753.tau.labone.domain.*;

public class PoolStorageImpl {
    HashMap<Integer,Pool> storage;

    public PoolStorageImpl(){
        this.storage = new HashMap<Integer,Pool>();
    }

    public void create(Pool pool) throws Exception {
        if(this.storage.containsKey(pool.getId())
        {
            throw new Exception("Id already added");
        }
        this.storage.put(pool.getId(), pool);
    }


}