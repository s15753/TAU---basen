package s15753.tau.labone.service;

// przyklad na podstawie przykladow J. Neumanna

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import s15753.tau.labone.domain.Pool;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PoolStorageTest {

	PoolStorage poolStorage;

	private final static Integer LENGTH_1 = 24;
	private final static Integer WIDTH_1 = 19;
	private final static Integer DEPTH_1 = 4;

	@Before
	public void setup() throws SQLException {
		poolStorage = new PoolStorageImpl();
	}

	@After
	public void cleanup() throws SQLException {
	}

	@Test
	public void checkConnection() {
		assertNotNull(poolStorage.getConnection());
	}

	@Test
	public void checkAdding() throws SQLException {
		Pool pool = new Pool();
		pool.setLength(LENGTH_1);
		pool.setWidth(WIDTH_1);
		pool.setDepth(DEPTH_1);


		assertEquals(1, poolStorage.create(pool));

		List<Pool> pools = poolStorage.readAll();
		Pool poolRetrieved = pools.get(0);

		assertEquals(LENGTH_1, poolRetrieved.getLength());
		assertEquals(WIDTH_1, poolRetrieved.getWidth());
		assertEquals(DEPTH_1, poolRetrieved.getDepth());
	}

}
