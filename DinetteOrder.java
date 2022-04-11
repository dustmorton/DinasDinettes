
/**
 * Class creates an order for processing and inventory. 
 *
 * @author Dustin Morton
 * @version Jan 27, 2019
 */
public class DinetteOrder {
    public static enum Option {CLEANING_KIT, SEAT_CUSHIONS, PADDED_FEET};

    public static final double TABLE_PRICE = 229.00;
    public static final double CHAIR_PRICE = 69.00;
    public static final double LEAF_PRICE = 45.00;
    public static final int TABLE_DEFAULT = 1;
    public static final int CHAIR_DEFAULT = 4;
    public static final int LEAF_DEFAULT = 0;
    public static final Option OPTION_DEFAULT = Option.CLEANING_KIT;
    public static final int CHAIR_MIN = 0;
    public static final int CHAIR_MAX = 10;
    public static final int LEAF_MIN = 0;
    public static final int LEAF_MAX = 2;

    private int orderNumber;
    private int chairCount;
    private int leafCount;
    private int tableCount = TABLE_DEFAULT;

    private Option option;
    private double price;

    /**
     * Constructor for DinetteOrder. Default is 1 table, 4 chairs, 0 leaves,
     * and Cleaning Kit option.
     * 
     * @param   orderNumber Order number from caller. 
     */
    public DinetteOrder(int orderNumber) {
        this(orderNumber, CHAIR_DEFAULT, LEAF_DEFAULT, OPTION_DEFAULT);
    }

    /**
     * Constructor 2 for DinetteOrder. 
     * 
     * @param   orderNumber Order number from caller.
     * @param   chairCount  Number of chairs on order, must be 0<=x<=10
     * @param   leafCount   Number of chairs on order, must be 0<=x<=2
     * @param   option      Option for add on item, must not be null
     */
    public DinetteOrder(int orderNumber, int chairCount, int leafCount, Option option) {
        if (chairCount < CHAIR_MIN || chairCount > CHAIR_MAX || leafCount < LEAF_MIN || leafCount > LEAF_MAX || option == null) {
            throw new IllegalArgumentException("Chair count needs to be 0<=x<=10. Leaf count needs to be 0<=x<=2. Option cannot be null.");
        }
        this.orderNumber = orderNumber;
        setChairCount(chairCount);
        setLeafCount(leafCount);
        setOption(option);
    }

    /**
     * Retrieves order number of order
     * 
     * @return     the order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Retrieves chair count of order
     * 
     * @return      chair count for order
     */
    public int getChairCount() {
        return chairCount;
    }

    /**
     * Retrieves leaf count of order
     * 
     * @return      leaf count for order
     */
    public int getLeafCount() {
        return leafCount;
    }

    /**
     * Retrieves table count of order
     * 
     * @return      table count for order
     */
    public int getTableCount() {
        return tableCount;
    }

    /**
     * Retrieves option item of order
     * 
     * @return      option item for order
     */
    public Option getOption() {
        return option;
    }

    /**
     * Retrieves total price of current order
     * 
     * @return      price of all items totalled
     */
    public double getPrice() {
        this.price = (CHAIR_PRICE * chairCount) + (LEAF_PRICE * leafCount) + (TABLE_PRICE * tableCount);

        return this.price;
    }

    /**
     * Sets count of chairs on order
     * 
     * @param   chairCount  number of chairs on current order, must be 0<=x<=10. 
     */
    public void setChairCount(int chairCount) {
        if (chairCount < CHAIR_MIN || chairCount > CHAIR_MAX) {
            throw new IllegalArgumentException("Chair count must be between 0 and 10.");
        }
        this.chairCount = chairCount;
    }

    /**
     * Sets count of leaves on order
     * 
     * @param   leafCount   number of leaves on current order, must be between 0<=x<=2.
     */
    public void setLeafCount(int leafCount) {
        if (leafCount < LEAF_MIN || leafCount > LEAF_MAX) {
            throw new IllegalArgumentException("Leaf count must be between 0 and 2.");
        }
        this.leafCount = leafCount;
    }

    /**
     * Sets option for current order
     * 
     * @param   option  option for added on item, must not be null
     */
    public void setOption(Option option) {
        if (option == null) {
            throw new IllegalArgumentException("Option cannot be null.");
        }
        this.option = option;
    }

    /**
     * Renders a string representation of the state of the order
     * 
     * @return      a string representing the state of the order
     */
    public String toString() {
        return "--Current order--\nOrder Number: " + orderNumber +
        "\nTable Count: " + tableCount + 
        "\nChair Count: " + chairCount +
        "\nLeaf Count: " + leafCount +
        "\nOption: " + option +
        "\nPrice: "  + getPrice() + "\n";
    }
}

