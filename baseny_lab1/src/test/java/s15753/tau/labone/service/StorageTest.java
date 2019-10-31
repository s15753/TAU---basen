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
    PoolManager database;

    @Before
    public void setup() {
        database = new PoolStorageImpl(new Pool(1, 2, 3, 4));

    }

    @Test
    public void storageConstructorCanAcceptNumberOfDimensionsTest() {
        assertNotNull(new PoolStorageImpl());
    }

    @Test
    public void readAllEntriesFromStorageTest() {
        assertEquals((Integer)1, database.readAll().get(0).getId());
    }

        @Test
    public void readEntryWithIdTest() {
        assertEquals((Integer)1, database.read(1).getId());
    }

    @Test
    public void createNewEntryInDatabaseTest() {
        Pool pool = new Pool(2, 5, 4, 3);
        database.create(pool);

        assertEquals((Integer)2, database.readAll().get(1).getId());
    }

    @Test
    public void updateDatabaseEntryTest() {
        database.update(1, 10, 10, 10);

        assertEquals((Integer)10, database.readAll().get(0).getLength());
    }

    @Test
    public void deleteEntryByIdCheckIfOtherIdWasNotDeletedTest() {
        database.create(new Pool(2, 4, 6, 8));
        database.delete(1);

        assertEquals((Integer)2, database.read(2).getId());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void noResultsToReturnFromDatabaseTest() {
        database.delete(1);

        database.readAll();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void noResultsToReturnForIdTest() {
        database.delete(1);

        database.read(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void createEntryForIdAlreadyExistInDatabaseTest() {
        Pool pool = new Pool(1, 5, 6, 7);
        database.create(pool);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteEntryFromDatabaseTest() {
        database.delete(1);

        database.read(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void updateEntryForIdNotExisitngInDatabaseTest() {
        database.update(2, 4, 5, 6);
    }
}