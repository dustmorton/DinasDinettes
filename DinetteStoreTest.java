
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the class DinetteStore
 *
 * @author  Dustin Morton
 * @version Jan 27, 2019
 */
public class DinetteStoreTest {
    /**
     * Default constructor for test class DinetteStoreTest
     */
    public DinetteStoreTest() {
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
    public void testConstructorAndGetsHappyPath() {
        DinetteStore testStore = new DinetteStore(50, 40, 30);
        assertEquals(50, testStore.getTableInventory());
        assertEquals(40, testStore.getChairInventory());
        assertEquals(30, testStore.getLeafInventory());
    }

    @Test  
    public void testTablesOnOrder() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);
        DinetteOrder testOrder1 = new DinetteOrder(1234, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        DinetteOrder testOrder2 = new DinetteOrder(1234, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        testStore.submitOrder(testOrder1);
        testStore.submitOrder(testOrder2);
        assertEquals(2, testStore.getTablesOnOrder());
    }

    @Test
    public void testGetChairsOnOrder() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);
        DinetteOrder testOrder1 = new DinetteOrder(1234, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        DinetteOrder testOrder2 = new DinetteOrder(1234, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);
        testStore.submitOrder(testOrder1);
        testStore.submitOrder(testOrder2);
        assertEquals(4, testStore.getChairsOnOrder());
    }

    @Test
    public void testGetLeavesOnOrder() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);
        DinetteOrder testOrder1 = new DinetteOrder(1234, 1, 2, DinetteOrder.Option.PADDED_FEET);
        DinetteOrder testOrder2 = new DinetteOrder(1234, 1, 2, DinetteOrder.Option.PADDED_FEET);
        testStore.submitOrder(testOrder1);
        testStore.submitOrder(testOrder2);        
        assertEquals(4, testStore.getLeavesOnOrder());
    }

    @Test
    public void testTotalSales() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);        
        DinetteOrder testOrder1 = new DinetteOrder(1234, 1, 1, DinetteOrder.Option.PADDED_FEET);
        DinetteOrder testOrder2 = new DinetteOrder(1234, 1, 1, DinetteOrder.Option.PADDED_FEET);
        testStore.submitOrder(testOrder1);        
        testStore.submitOrder(testOrder2);
        assertEquals(686.0, testStore.getTotalSales(), 0.01);
    }

    @Test
    public void testAvgOrderPrice() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);
        DinetteOrder testOrder1 = new DinetteOrder(1234, 1, 1, DinetteOrder.Option.PADDED_FEET);
        DinetteOrder testOrder2 = new DinetteOrder(1234, 2, 1, DinetteOrder.Option.PADDED_FEET);

        testStore.submitOrder(testOrder1);        
        testStore.submitOrder(testOrder2);
        assertEquals(377.5, testStore.getAvgOrderPrice(), 0.01);
    }

    @Test
    public void testSubmitOrder() {
        DinetteStore testStore = new DinetteStore(10, 20, 30);
        DinetteOrder testOrder = new DinetteOrder(1234, 2, 2, DinetteOrder.Option.SEAT_CUSHIONS);

        assertEquals(457.0, testStore.submitOrder(testOrder), 0.01);

    }

    //-----------------------------------------------------------------------------------------
    //          Precondition Tests
    //------------------------------------------------------------------------

    @Test (expected = IllegalArgumentException.class)
    public void testPrecondNegInventory() {
        DinetteStore testStore = new DinetteStore(-999, 999, 999);
        DinetteStore testStore1 = new DinetteStore(-999, -999, 999);
        DinetteStore testStore2 = new DinetteStore(-999, -999, -999);
        DinetteStore testStore3 = new DinetteStore(999, -999, 999);
        DinetteStore testStore4 = new DinetteStore(999, 999, -999);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrecondNullOrder() {
        DinetteStore testStore = new DinetteStore(999, 999, 999);
        DinetteOrder testOrder = null;
        testStore.submitOrder(testOrder);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrecondEnoughInventoryForTables() {
        DinetteStore testStore = new DinetteStore(0, 2, 2);
        DinetteOrder testOrder = new DinetteOrder(123456);
        testStore.submitOrder(testOrder);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrecondEnoughInventoryForChairs() {
        DinetteStore testStore = new DinetteStore(1, 2, 2);
        DinetteOrder testOrder = new DinetteOrder(123456, 3, 0, DinetteOrder.Option.SEAT_CUSHIONS);
        testStore.submitOrder(testOrder);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrecondEnoughInventoryForLeaves() {
        DinetteStore testStore = new DinetteStore(1, 2, 2);
        DinetteOrder testOrder = new DinetteOrder(123456, 2, 3, DinetteOrder.Option.SEAT_CUSHIONS);
        testStore.submitOrder(testOrder);
    }    
}
