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

}