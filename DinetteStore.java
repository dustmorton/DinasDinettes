
/**
 * Class holds store inventory, total sales, and average order price. It also 
 * submits an order from DinetteOrder class.
 *
 * @author Dustin Morton
 * @version Jan 27, 2019
 */
public class DinetteStore {
    private int tableInventory;
    private int chairInventory;
    private int leafInventory;
    private int tablesOnOrder;
    private int chairsOnOrder;
    private int leavesOnOrder;
    private double totalSales;
    private double avgOrderPrice;
    private int numOfOrders;

    /**
     * Constructor for DinetteStore objects
     * 
     * @param   tableInventory  number of tables to add to inventory, cannot be < 0
     * @param   chairInventory  number of chairs to add to inventory, cannot be < 0
     * @param   leafInventory   number of leaves to add to inventory, cannot be < 0
     */
    public DinetteStore(int tableInventory, int chairInventory, int leafInventory) {
        if (tableInventory < 0 || chairInventory < 0 || leafInventory < 0) {
            throw new IllegalArgumentException("Inventory numbers cannot be below 0.");
        }
        this.tableInventory = tableInventory;
        this.chairInventory = chairInventory;
        this.leafInventory = leafInventory;
    }

    /**
     * Retrieves current table inventory, value includes current orders
     * 
     * @return      number of tables in inventory
     * 
     */
    public int getTableInventory() {
        return tableInventory;
    }

    /**
     * Retrieves current chair inventory, value includes current orders
     * 
     * @return      number of chairs in inventory
     */
    public int getChairInventory() {
        return chairInventory;
    }

    /**
     * Retrieves current leaf inventory, value includes current orders
     * 
     * @return      number of leaves in inventory
     */
    public int getLeafInventory() {
        return leafInventory;
    }

    /**
     * Retrieves number of tables on order
     * 
     * @return      current number of tables on order
     */
    public int getTablesOnOrder() {
        return tablesOnOrder;
    }

    /**
     * Retrieves number of chairs on order
     * 
     * @return      current number of chairs on order
     */
    public int getChairsOnOrder() {
        return chairsOnOrder;
    }

    /**
     * Retrieves number of leaves on order
     *
     * @return      current number of leaves on order
     */
    public int getLeavesOnOrder() {
        return leavesOnOrder;
    }

    /**
     * Retrieves total sales from all orders
     * 
     * @return      total sales from all orders
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * Retrieves average price of all orders
     * 
     * @return      average price of all orders
     */
    public double getAvgOrderPrice() {
        return avgOrderPrice;
    }

    /**
     * Submits order for processing
     * 
     * @param   order   DinetteOrder object from caller, cannot be null
     *                  order table,chair, and leaf values may not may not exceed inventory
     * @return          price of current order
     */
    public double submitOrder(DinetteOrder order) {
        if (order == null || order.getTableCount() > tableInventory || order.getChairCount() > chairInventory || order.getLeafCount() > leafInventory) {
            throw new IllegalArgumentException("Inventory insufficient for order");
        }

        this.chairInventory -= order.getChairCount();
        this.leafInventory -= order.getLeafCount();
        this.tableInventory -= order.getTableCount();
        this.chairsOnOrder += order.getChairCount();
        this.leavesOnOrder += order.getLeafCount();
        this.tablesOnOrder += order.getTableCount();
        this.totalSales += order.getPrice();
        this.numOfOrders += 1;
        this.avgOrderPrice = totalSales / numOfOrders;
        
        return order.getPrice();
    }

    /**
     * Renders a string representation of the state of the store
     * 
     * @return      a string representing the state of the store
     */
    public String toString() {
        return "--Current inventory--\nTables: " + this.tableInventory + 
        "\nChairs: " + chairInventory +
        "\nLeaves: " + leafInventory + 
        "\nTotal Sales: " + totalSales +
        "\nAverage Order Price: " + avgOrderPrice + "\n";

    }
   
}
