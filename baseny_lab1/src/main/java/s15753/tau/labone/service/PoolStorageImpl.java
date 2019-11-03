package s15753.tau.labone.service;

import java.time.Clock;
import java.util.ArrayList;

import s15753.tau.labone.domain.Pool;

public class PoolStorageImpl implements PoolManager{

    private ArrayList<Pool> storage;
    private Clock clock;

    private boolean is_add_dt = true;
    private boolean is_updt_dt = true;
    private boolean is_read_dt = true;

    public PoolStorageImpl() {
        this.storage = new ArrayList<Pool>();
    }

    public PoolStorageImpl(Pool pool) {
        this.storage = new ArrayList<Pool>();
        storage.add(pool);
    }

    public void settAddInd(Boolean is_add_dt) { this.is_add_dt = is_add_dt; }

    public boolean getAddInd() { return this.is_add_dt; }

    public void settUpdtInd(Boolean is_updt_dt) { this.is_updt_dt = is_updt_dt; }

    public boolean getUpdtInd() { return this.is_updt_dt; }

    public void settReadInd(Boolean is_updt_dt) { this.is_read_dt = is_read_dt; }

    public boolean getReadInd() { return this.is_read_dt; }

    @Override
    public void create(Pool pool) {
        for(Pool p: storage) {
            if (p.getId() == pool.getId()) {
                throw new IndexOutOfBoundsException("Id already exist");
            }
        }
        if(is_add_dt){
            pool.setAddDt(Clock.systemDefaultZone());
            storage.add(pool);
        }
        else { storage.add(pool); }

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
