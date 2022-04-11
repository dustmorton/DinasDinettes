
/**
 * Just for testing classes
 *
 * @author Dustin Morton
 * @version Jan 27, 2019
 */
public class Testing
{
    public static void main(String[] args) {
        System.out.print("\u000c");
        DinetteOrder dinOrder = new DinetteOrder(464545, 1, 1, DinetteOrder.Option.CLEANING_KIT);
        DinetteOrder dinOrder1 = new DinetteOrder(464545);
        DinetteOrder dinOrder2 = new DinetteOrder(464545, 2, 2, DinetteOrder.Option.PADDED_FEET);
        
        
        DinetteStore dinStore = new DinetteStore(10, 20, 30); 
        
        dinStore.submitOrder(dinOrder);
        //System.out.println(dinStore.getTablesOnOrder());
        dinStore.submitOrder(dinOrder1);
        dinStore.submitOrder(dinOrder2);
       
         System.out.println(dinStore);
        System.out.println(dinOrder);
        System.out.println(dinOrder1);
        System.out.println(dinOrder2);
        System.out.println(dinStore.getTotalSales());
        
        
        
        //System.out.println(dinStore);
        //System.out.println(dinStore.getLeavesOnOrder());
    }
}
