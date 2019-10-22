package s15753.tau.labone.service;

import s15753.tau.labone.domain.Pool;

import java.util.ArrayList;

public interface PoolManager {

    public void create(Pool pool);

    public ArrayList<Pool> readAll();

    public Pool read(Integer id);

    public void update(Integer id, Integer length, Integer width, Integer depth);

    public void delete(Integer id);
}
