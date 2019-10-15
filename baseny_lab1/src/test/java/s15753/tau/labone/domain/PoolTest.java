 
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

    @Test(expected = IllegalArgumentException.class)
    public void poolConstructorCanNotAcceptLessNumberOfDimensions() {
        ew Pool(1, 2.2, 3.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void poolConstructorCanNotAcceptMoreNumberOfDimensions() {
        new Pool(1, 2.2, 3.3, 4.4, 5);
    }

}