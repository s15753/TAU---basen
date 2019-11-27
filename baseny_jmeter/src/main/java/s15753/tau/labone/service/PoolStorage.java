package s15753.tau.labone.service;

import s15753.tau.labone.domain.Pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PoolStorage {
    public Connection getConnection();

    public void setConnection(Connection connection) throws SQLException;

    public int create(Pool pool) throws SQLException;

    public List<Pool> readAll() throws SQLException;

    public Pool read(Integer id) throws SQLException;

    public int update(Integer id, Pool pool) throws SQLException;

    public int delete(Integer id);

    public int deleteAll();

    public String introduceSelf();
}
