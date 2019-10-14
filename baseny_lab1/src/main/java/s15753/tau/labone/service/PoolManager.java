package s15753.tau.labone.service;

public interface PoolManager {

    public void addPool(int id, Double length, Double width, Double depth);
    public Pool getPool(int id);
    public void updatePool(int id, Double length, Double width, Double depth);
    public void deletePool(int id);

}