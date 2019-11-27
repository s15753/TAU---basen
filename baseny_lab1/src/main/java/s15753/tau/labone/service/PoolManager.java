package s15753.tau.labone.service;

import s15753.tau.labone.domain.Pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PoolManager {

    public void settAddInd(Boolean is_add_dt);

    public boolean getAddInd();

    public void settUpdtInd(Boolean is_updt_dt);

    public boolean getUpdtInd();

    public void settReadInd(Boolean is_updt_dt);

    public boolean getReadInd();

    public void create(Pool pool);

    public ArrayList<Pool> readAll();

    public Pool read(Integer id);

    public void update(Integer id, Integer length, Integer width, Integer depth);

    public void delete(Integer id);
}
