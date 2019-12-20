package s15753.tau.labone.service;


import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import s15753.tau.labone.domain.Pool;

@Component
public class PoolStorageImpl implements PoolStorage{

    private Connection connection;

    private PreparedStatement addPoolStmt;
    private PreparedStatement getAllPoolsStmt;
    private PreparedStatement getPoolStmt;
    private PreparedStatement deletePoolStmt;
    private PreparedStatement deleteAllStmt;
    private PreparedStatement updatePoolStmt;


    public PoolStorageImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        if (!isDatabaseReady()) {
            createTables();
        }
        this.setConnection(this.connection);
    }

    public PoolStorageImpl(Connection connection) throws SQLException {
        this.connection = connection;
        if (!isDatabaseReady()) {
            createTables();
        }
        setConnection(connection);
    }

    @Override
    public int create(Pool pool) throws SQLException {
        int count = 0;
        try {
            addPoolStmt.setInt(1, pool.getLength());
            addPoolStmt.setInt(2, pool.getWidth());
            addPoolStmt.setInt(3, pool.getDepth());

            count = addPoolStmt.executeUpdate();
            ResultSet generatedKeys = addPoolStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pool.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        return count;
    }

    @Override
    public List<Pool> readAll() throws SQLException {
        List<Pool> pools = new LinkedList<>();
        try {
            ResultSet rs = getAllPoolsStmt.executeQuery();

            while (rs.next()) {
                Pool p = new Pool();
                p.setId(rs.getInt("id"));
                p.setLength(rs.getInt("length"));
                p.setWidth(rs.getInt("width"));
                p.setDepth(rs.getInt("depth"));
                pools.add(p);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        return pools;
    }

    @Override
    public Pool read(Integer id) throws SQLException {
        try {
            getPoolStmt.setInt(1, id);
            ResultSet rs = getPoolStmt.executeQuery();

            if (rs.next()) {
                Pool p = new Pool();
                p.setId(rs.getInt("id"));
                p.setLength(rs.getInt("length"));
                p.setWidth(rs.getInt("width"));
                p.setDepth(rs.getInt("depth"));
                return p;
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        throw new SQLException("Pool with id " + id + " does not exist");
    }

    @Override
    public int update(Integer id, Pool pool) throws SQLException {
        int count = 0;
        try {
            updatePoolStmt.setInt(1, pool.getLength());
            updatePoolStmt.setInt(2, pool.getWidth());
            updatePoolStmt.setInt(3, pool.getDepth());
            updatePoolStmt.setInt(4, id);
            count = updatePoolStmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        if (count <= 0)
            throw new SQLException("Pool not found for update");
        return count;
    }

    @Override
    public int delete(Integer id) {
        try {
            deletePoolStmt.setInt(1, id);
            return deletePoolStmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public int deleteAll() {
        try {
            return deleteAllStmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public String introduceSelf() {
        return null;
    }

    public void createTables() throws SQLException {
        connection.createStatement()
                .executeUpdate("CREATE TABLE " + "Pool(id integer GENERATED BY DEFAULT AS IDENTITY, "
                        + "length integer NOT NULL, " + "width integer NOT NULL, "
                        + "depth integer  NOT NULL)");
    }

    public boolean isDatabaseReady() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Pool".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }
            return tableExists;
        } catch (SQLException e) {
            return false;
        }
    }

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        addPoolStmt = connection.prepareStatement(
                "INSERT INTO Pool (length, width, depth) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        deletePoolStmt = connection.prepareStatement("DELETE FROM Pool where id = ?");
        getAllPoolsStmt = connection.prepareStatement("SELECT id, length, width, depth FROM Pool ORDER BY id");
        getPoolStmt = connection.prepareStatement("SELECT id, length, width, depth FROM Pool WHERE id = ?");
        updatePoolStmt = connection.prepareStatement("UPDATE Pool SET length=?,width=?,depth=? WHERE id = ?");
        deleteAllStmt = connection.prepareStatement("DELETE FROM Pool");
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}