
/**
 * This class implements the slot to be used on the main function of vending machine.
 * It includes a list of items it has that can be sold, total number of items sold and the
 * primary item it holds.
 * 
 * @author Adriel Manuel D. Fancubit
 */

public class Slot {

    private Item primaryItem; // the original item placed


    /**
     * Constructs a slot with the given item.
     *
     * @param item the item to be placed in the slot
     *
     *
     */
    Slot(Item item)
    {
        this.primaryItem = item;
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


}
