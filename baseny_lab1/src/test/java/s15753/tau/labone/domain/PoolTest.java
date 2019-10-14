 
package s15753.tau.labone.domain;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnit4.class)
public class PoolTest {

    @Test
    public void poolConstructorCanAcceptNumberOfDimensionsTest() {
        assertNotNull(new Pool(1, 2.2, 3.3, 4.4));
    }

    @Test
    public void poolConstructorCanNotAcceptLessNumberOfDimensions() {
        assertNull(new Pool(1, 2.2, 3.3));
    }

    @Test
    public void poolConstructorCanNotAcceptMoreNumberOfDimensions() {
        assertNull(new Pool(1, 2.2, 3.3, 4.4, 5));
    }

//    @Test
//    public void poolAddedToDatabase() {
//       pool = new Pool(1, 2.2, 3.2, 4.1);
//       assertNotNull(Pool.addPool(pool));
   }

}