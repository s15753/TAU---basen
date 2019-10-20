package s15753.tau.labone.service;

import static org.junit.Assert.*;

import s15753.tau.labone.domain.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnit4.class)
public class StorageTest {


    @Before
    public void setup() {
        ArrayList<Pool> database = new ArrayList<Pool>(Arrays.asList(new Pool(1, 2, 3, 4)));
        System.out.print(database.size());
    }

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
    public void readEntryWithIdTest() {
        PoolStorageImpl database = new PoolStorageImpl();

        assertEquals(1, database.read(1).getId());
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

    @Test
    public void deleteEntryByIdCheckIfOtherIdWasNotDeletedTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        database.create(new Pool(2, 4, 6, 8));
        database.delete(1);

        assertEquals(2, database.read(2).getId());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void noResultsToReturnFromDatabaseTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        database.delete(1);

        database.readAll();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void noResultsToReturnForIdTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        database.delete(1);

        database.read(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void createEntryForIdAlreadyExistInDatabaseTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        Pool pool = new Pool(1, 5, 6, 7);
        database.create(pool);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteEntryFromDatabaseTest() {
        PoolStorageImpl database = new PoolStorageImpl();
        database.delete(1);

        database.read(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void updateEntryForIdNotExisitngInDatabaseTest() {
        PoolStorageImpl database = new PoolStorageImpl();

        database.update(2, 4, 5, 6);
    }
}