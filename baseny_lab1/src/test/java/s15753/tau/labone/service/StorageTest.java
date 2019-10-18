package s15753.tau.labone.service;

import static org.junit.Assert.*;

import s15753.tau.labone.domain.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnit4.class)
public class StorageTest {

    @Before
    public void setUp(){
        Poll pool_1 = new Pool(1, 2.0, 3.0, 4.0);
        PoolStorageImpl storage = new PoolStorageImpl();
        storage.put(1, pool_1);
    }

    @Test
    public void storageConstructorCanAcceptNumberOfDimensionsTest() {
        assertNotNull(new PoolStorageImpl());
    }

    @Test
    public void addEntryToStorageTest() {
        Pool pool_2 = new Pool(2, 4.0, 5.0, 6.0);
        storage.create(pool_2);
        assertTrue(storage.get(2).getId() == 2);
    }


}