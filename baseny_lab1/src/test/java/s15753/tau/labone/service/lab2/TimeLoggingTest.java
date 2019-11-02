package s15753.tau.labone.service.lab2;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;

import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import s15753.tau.labone.domain.Pool;
import s15753.tau.labone.service.PoolManager;
import s15753.tau.labone.service.PoolStorageImpl;

import java.sql.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(MockitoJUnitRunner.class)
public class TimeLoggingTest {
    PoolManager database;

    private static final LocalDateTime CREATE_TIME = LocalDateTime.of(2017,10, 26, 17, 17, 17);
    private static final LocalDateTime READ_TIME = LocalDateTime.of(2019, 10, 30, 10, 10, 10);
    private static final LocalDateTime WRITE_TIME = LocalDateTime.of(2019, 11, 1, 20, 20,20);

    @InjectMocks
    Pool first_pool;
    Pool second_pool;

    @Mock
    Clock clock;

    private void mockTime(LocalDateTime time) {
        Clock fixedClock = Clock.fixed(time.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        first_pool = new Pool(1, 2, 3, 4);
        second_pool = new Pool(2, 3, 4, 5);
        database = new PoolStorageImpl(first_pool);
    }

    @Test
    public void defaultAddFlagSetToTrueTest() {
        assertEquals(true, database.getAddInd());
    }

    @Test
    public void defaultUpdtFlagSetToTrueTest() {
        assertEquals(true, database.getUpdtInd());
    }

    @Test
    public void defaultreadFlagSetToTrueTest() {
        assertEquals(true, database.getReadInd());
    }
}
