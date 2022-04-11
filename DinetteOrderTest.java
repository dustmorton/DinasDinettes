
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the class DinetteOrder
 *
 * @author  Dustin Morton
 * @version (a version number or a date)
 */
public class DinetteOrderTest {
    /**
     * Default constructor for test class DinetteOrderTest
     */
    public DinetteOrderTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    //-----------------------------------------------------------------------------------------
    //          Happy Path Tests
    //--------------------------------------------------------------------------
    @Test
    public void testFirstConstructorAndGetsHappyPath() {
        DinetteOrder testOrder = new DinetteOrder(999);
        assertEquals(999, testOrder.getOrderNumber());
        assertEquals(1, testOrder.getTableCount());
        assertEquals(4, testOrder.getChairCount());
        assertEquals(0, testOrder.getLeafCount());
        assertEquals(DinetteOrder.Option.CLEANING_KIT, testOrder.getOption());
    }

    @Test
    public void testSecondConstructorAndGetsHappyPath() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        assertEquals(999, testOrder.getOrderNumber());
        assertEquals(1, testOrder.getTableCount());
        assertEquals(2, testOrder.getChairCount());
        assertEquals(2, testOrder.getLeafCount());
        assertEquals(DinetteOrder.Option.SEAT_CUSHIONS, testOrder.getOption());
    }

    @Test
    public void testGetPrice() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        assertEquals(457.0, testOrder.getPrice(), 0.01);
    }

    @Test
    public void testSetChairCount() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        testOrder.setChairCount(5);
        assertEquals(5, testOrder.getChairCount());
    }

    @Test
    public void testSetLeafCount() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        testOrder.setLeafCount(1);
        assertEquals(1, testOrder.getLeafCount());
    }

    @Test
    public void testSetOption() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        testOrder.setOption(DinetteOrder.Option.CLEANING_KIT);
        assertEquals(DinetteOrder.Option.CLEANING_KIT, testOrder.getOption());
    }

    //-----------------------------------------------------------------------------------------
    //          Precondition Tests
    //------------------------------------------------------------------------

    @Test (expected = IllegalArgumentException.class)
    public void testChairCountNotUnderRange() {
        DinetteOrder testOrder = new DinetteOrder(999, -1, 2, DinetteOrder.Option.SEAT_CUSHIONS);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChairCountNotOverRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 11, 2, DinetteOrder.Option.SEAT_CUSHIONS);
    }

    @Test (expected = IllegalArgumentException.class) 
    public void testLeafCountNotUnderRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, -1, DinetteOrder.Option.SEAT_CUSHIONS);
    }

    @Test (expected = IllegalArgumentException.class) 
    public void testLeafCountNotOverRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 3, DinetteOrder.Option.SEAT_CUSHIONS);
    }

    @Test (expected = IllegalArgumentException.class) 
    public void testOptionNotNull() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetChairCountForUnderRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, DinetteOrder.Option.PADDED_FEET);
        testOrder.setChairCount(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetChairCountForOverRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, DinetteOrder.Option.PADDED_FEET);
        testOrder.setChairCount(11);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetLeafCountForUnderRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, DinetteOrder.Option.PADDED_FEET);
        testOrder.setLeafCount(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetLeafCountForOverRange() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, DinetteOrder.Option.PADDED_FEET);
        testOrder.setLeafCount(3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetOptionForNull() {
        DinetteOrder testOrder = new DinetteOrder(999, 2, 1, DinetteOrder.Option.PADDED_FEET);
        testOrder.setOption(null);
    }    
}
