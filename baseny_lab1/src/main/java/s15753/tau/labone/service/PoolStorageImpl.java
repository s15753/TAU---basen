package s15753.tau.labone.service;

import java.util.ArrayList;
import java.util.Arrays;
import s15753.tau.labone.domain.Pool;

public class PoolStorageImpl {
    private ArrayList<Pool> storage = new ArrayList<Pool>(Arrays.asList(new Pool(1, 2.0, 3.0, 4.0)));


    public void create(Pool pool)  {
        storage.add(pool);
    }

    public ArrayList<Pool> readAll() {
        return storage;
    }



    public void update(int id, Double length, Double width, Double depth) throws Exception {
            for(Pool p: storage ) {
                if (p.getId() == id) {
                    throw new IllegalArgumentException();
                }
            }
        Pool updatedPool = storage.get(id);
        updatedPool.setLength(length);
        updatedPool.setWidth(width);
        updatedPool.setDepth(depth);

    }

}
