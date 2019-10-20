package s15753.tau.labone.service;

import static org.junit.Assert.*;

import s15753.tau.labone.domain.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnit4.class)
public class StorageTest {


    @Test
    public void storageConstructorCanAcceptNumberOfDimensionsTest() {
        assertNotNull(new PoolStorageImpl());
    }

    @Test
    public void readAllEntriesFromStorageTest() {
        PoolStorageImpl database = new PoolStorageImpl();

        assertEquals(1, database.readAll().get(0).getId());
    }

    @Test
    public void createNewEntryInDatabaseTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        Pool pool = new Pool(2, 5, 4, 3);

        database.create(pool);

        assertEquals(2, database.readAll().get(1).getId());
    }

    @Test
    public void updateDatabaseEntryTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        database.update(1, 10, 10, 10);

        assertEquals((Integer)10, database.readAll().get(0).getLength());
    }

    




}