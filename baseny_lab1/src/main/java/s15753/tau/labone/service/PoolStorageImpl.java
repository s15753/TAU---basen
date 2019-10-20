package s15753.tau.labone.service;

import java.util.ArrayList;
import java.util.Arrays;
import s15753.tau.labone.domain.Pool;

public class PoolStorageImpl {

    private ArrayList<Pool> storage = new ArrayList<Pool>(Arrays.asList(new Pool(1, 2.0, 3.0, 4.0)));

    public void create(Pool pool) {

        storage.add(pool);
    }

    public ArrayList<Pool> readAll() {
        return storage;
    }


    public void update(Integer id, Double length, Double width, Double depth) {
        for(Pool p: storage) {
            if(p.getId() == id) {
                p.setLength(length);
                p.setWitdh(width);
                p.setDepth(depth);
            }
        }

    }

    public void delete(Integer id) {
        for(Pool p: storage) {
            if(p.getId() == id) {
                storage.remove(storage.indexOf(p));
            }
        }
    }

}
