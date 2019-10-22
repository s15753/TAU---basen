package s15753.tau.labone.service;

import java.util.ArrayList;
import java.util.Arrays;
import s15753.tau.labone.domain.Pool;

public class PoolStorageImpl implements PoolManager{

    private ArrayList<Pool> storage;

    public PoolStorageImpl() {
        this.storage = new ArrayList<Pool>();
    }

    public PoolStorageImpl(Pool pool) {
        this.storage = new ArrayList<Pool>();
        storage.add(pool);
    }

    @Override
    public void create(Pool pool) {
        for(Pool p: storage) {
            if(p.getId() == pool.getId()) {
                throw new IndexOutOfBoundsException("Id already exist");
            }
        }
        storage.add(pool);
    }

    @Override
    public ArrayList<Pool> readAll() {
        if(storage.size() > 0) {
            return storage;
        }
        else {
            throw new IndexOutOfBoundsException("No entries in database");
        }
    }

    @Override
    public Pool read(Integer id) {
        Pool result = null;
        for(Pool p: storage) {
            if(p.getId() == id) {
                result = p;
            }
        }
        if (result == null) {
            throw new IndexOutOfBoundsException("Id doesn't exist");
        }

        return result;
    }

    @Override
    public void update(Integer id, Integer length, Integer width, Integer depth) {
        for(Pool p: storage) {
            if(p.getId() != id) {
                throw new IndexOutOfBoundsException("Id doesn't exist");
            }
        }

        for(Pool p: storage) {
            if(p.getId() == id) {
                p.setLength(length);
                p.setWidth(width);
                p.setDepth(depth);
            }
        }

    }

    @Override
    public void delete(Integer id) {
        for(int i = 0; i < storage.size(); i++) {
            if(storage.get(i).getId() == id) {
                storage.remove(i);
            }
        }
    }

}
