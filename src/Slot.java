import java.util.ArrayList;
/**
 * This class implements the slot to be used on the main function of vending machine.
 * It includes a list of items it has that can be sold, total number of items sold and the
 * primary item it holds.
 * 
 * @author Adriel Manuel D. Fancubit
 */

public class Slot {

    private int totalSold; // number of items sold
    private Item primaryItem; // the original item placed
    private int totalRemainingItem;


    /**
     * Constructs a slot with the given item and its initial quantity. This also creates
     * the item object, that can only be purchased through this slot.
     *
     * @param item the item to be placed in the slot
     * @param itemQuantity the initial quantity of the item in the slot
     *
     */
    Slot(Item item, int itemQuantity)
    {
        this.primaryItem = new Item(item);
        this.totalRemainingItem = itemQuantity;
        totalSold = 0;
    }

    public void setTotalRemainingItem(int totalRemainingItem) {
        this.totalRemainingItem = totalRemainingItem;
    }

    /**
     * This function sets a slot with an existing slot
     *
     * @param another another Slot
     */

    public void anotherSlot(Slot another)
    {
        this.primaryItem = another.getPrimaryItem();
        this.totalSold = another.getTotalSold();
    }




    /**
     *
     * Checks if the items in the slot are currently stocked
     *
     * @return boolean whether if the item is available or not
     */



    /**
     *
     * Adds stock to the given item
     *
     * @param stockQuantity  the stock quantity.
     * @param item  the item.
     */






    /**
     *
     * Gets the total number of items sold by the slot
     *
     * @return the total sold
     */
    public int getTotalSold() {

        return totalSold;
    }


    /**
     *
     * Gets the primary item
     *
     * @return the primary item inside the slot
     */
    public Item getPrimaryItem() {

        return primaryItem;
    }


    /**
     *
     * Sets the primary item sold by the item
     *
     * @param primaryItem  the primary item.
     */
    public void setPrimaryItem(Item primaryItem) {

        this.primaryItem = primaryItem;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public int getTotalRemainingItem() {
        return totalRemainingItem;
    }
}
