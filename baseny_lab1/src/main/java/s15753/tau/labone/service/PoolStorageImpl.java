package s15753.tau.labone.service;

import java.util.ArrayList;
import java.util.Arrays;
import s15753.tau.labone.domain.Pool;

public class PoolStorageImpl {
    private ArrayList<Pool> storage = new ArrayList<Pool>();



    public void create(Pool pool) throws Exception {
        for(Pool p: storage ) {
            if(p.getId() == pool.getId())
            {
                throw new IllegalArgumentException();
            }
        storage.add(pool);
    }

    public ArrayList<Pool> readAll() {
        return storage;
    }

    public ArrayList<Pool> read(Integer id) throws Exception {
        for(Pool p: storage) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new Exception("Id not found");
    }

    public void update(int id, Double length, Double width, Double depth) throws Exception {
            for(Pool p: storage ) {
                if(p.getId() == id)
                {
                    throw new IllegalArgumentException();
                }
        Pool updatedPool = storage.get(id);
        updatedPool.setLength(length);
        updatedPool.setWidth(width);
        updatedPool.setDepth(depth);

    }

}
