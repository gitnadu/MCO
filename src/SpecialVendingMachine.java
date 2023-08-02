
import java.util.ArrayList;
/**
 * The class implements a special vending machine that has the features of a regular vending machine
 * but can also customize items.
 *
 * @author Adriel Manuel D. Fancubit
 */

public class SpecialVendingMachine extends RegularVendingMachine{

    private ArrayList<Integer> baseItemIndex = new ArrayList<>();
    private ArrayList<Integer> otherItemIndex = new ArrayList<>();

    private ArrayList<Item>[] exclusiveItems = new ArrayList[12];
    private Item[] exclusiveItemRecord =  new Item[12];
    private ExclusiveSlot[] exclusiveSlot = new ExclusiveSlot[12];

    private int CURRENTnumberOfExclusiveItems;
    private int CURRENTnumberOfExclusiveSlots;
    // the items that are only available for the special vending machine
    private ArrayList<Item> customizedItem;
    SpecialTransaction specialCurrentTransaction;
    // arraylist of items that will be customized

    /**
     *Constructs a special vending machine. To construct a special vending machine,
     * its name must be specified
     *
     * @param name the name of the vending machine
     *
     */
    SpecialVendingMachine(String name)
    {
        super(name);
        for(int i = 0;i<12;i++)
        {
            exclusiveItems[i] = new ArrayList<Item>();
            exclusiveItemRecord[i] = new Item("", 0,0);
            exclusiveSlot[i] = new ExclusiveSlot(exclusiveItemRecord[i]);
        }

        customizedItem = new ArrayList<>();
        CURRENTnumberOfExclusiveItems = 0; // no exclusive items in the machine
        CURRENTnumberOfExclusiveSlots = 0;
    }


    /**
     *
     * Gets the indexes of the base items, this also gets the count of the base items
     *
     * @return the arraylist of indexes mapped to base items
     */
    public ArrayList<Integer> getBaseItemIndex() {

        return baseItemIndex;
    }


    /**
     *
     * Gets the indexes of the dependent items, this also gets the count of the dependent items
     *
     * @return the arraylist of indexes mapped to dependent items
     */
    public ArrayList<Integer> getOtherItemIndex() {

        return otherItemIndex;
    }



    /**
     *
     * Add base item
     *
     * @param itemName  the item name.
     * @param itemPrice  the item price.
     * @param itemCalories  the item calories.
     * @param itemQuantity  the item quantity.
     * @return true if item is successfully added
     */
    public boolean addBaseItem(String itemName , float itemPrice, float itemCalories, int itemQuantity)
    {

        if (itemPrice < 0)
        {
            return false;
        }

        if (itemCalories < 0)
        {
            return false;
        }

        if (itemQuantity < 0)
        {
            return false;
        }

        System.out.println("Adding base item");
        BaseItem tempItem = new BaseItem(itemName,itemPrice,itemCalories);

        for (int i=0;i<itemQuantity;i++)
        {
            exclusiveItems[CURRENTnumberOfExclusiveItems].add(tempItem); // adds the items to the
        }

        exclusiveItemRecord[CURRENTnumberOfExclusiveItems] = tempItem;
        exclusiveItemRecord[CURRENTnumberOfExclusiveItems].setSlotNumber(CURRENTnumberOfExclusiveItems);

        baseItemIndex.add(CURRENTnumberOfExclusiveItems);

        exclusiveSlot[CURRENTnumberOfExclusiveSlots].setPrimaryItem(tempItem);

        CURRENTnumberOfExclusiveItems++;
        CURRENTnumberOfExclusiveSlots++;

        return true;
    }


    /**
     *
     * Add other item
     *
     * @param itemName  the item name.
     * @param itemPrice  the item price.
     * @param itemCalories  the item calories.
     * @param itemQuantity  the item quantity.
     * @return true if item is successfully added
     */
    public boolean addOtherItem(String itemName ,float itemPrice, float itemCalories,  int itemQuantity)
    {

        if (itemPrice < 0)
        {
            return false;
        }

        if (itemCalories < 0)
        {
            return false;
        }

        if (itemQuantity < 0)
        {
            return false;
        }

        System.out.println("Adding base item");
        DependentItem tempItem = new DependentItem(itemName,itemPrice,itemCalories);

        for (int i=0;i<itemQuantity;i++)
        {
            exclusiveItems[CURRENTnumberOfExclusiveItems].add(tempItem); // adds the items to the
        }

        exclusiveItemRecord[CURRENTnumberOfExclusiveItems] = tempItem;
        exclusiveItemRecord[CURRENTnumberOfExclusiveItems].setSlotNumber(CURRENTnumberOfExclusiveItems);
        exclusiveSlot[CURRENTnumberOfExclusiveSlots].setPrimaryItem(tempItem);

        otherItemIndex.add(CURRENTnumberOfExclusiveItems);

        CURRENTnumberOfExclusiveItems += 1;
        CURRENTnumberOfExclusiveSlots += 1;

        return true;
    }
    // adding another item in the machine




    /**
     *
     * Customizing item
     *
     * @param item  the item to be added to the list of items to be customized
     * @return true if successfully added
     */
    public boolean customizingItem(Item item)
    {


        if (isExclusiveItemAvailable(item))
        {
            customizedItem.add(item);
            return true;
        }
        return false;
    }


    /**
     *
     * Gets the total calories of the customized item
     *
     * @return the total calories of the customized item
     */
    public float getCaloriesCustomizedItem()
    {

        float sum = 0;
        // iterates over the calories of each item
        for(int i = 0; i <customizedItem.size();i++)
        {

            sum += customizedItem.get(i).getCalories();

        }

        return sum;
    }



    /**
     *
     * Gets the total price of customized item
     *
     * @return the total price of customized item
     */
    public float getPriceCustomizedItem()
    {

        float sum = 0;
        // iterates over the price of each item
        for(int i = 0; i <customizedItem.size();i++)
        {
            sum += customizedItem.get(i).getPrice();
        }

        return sum;
    }



    /**
     *
     * Purchase the customized item
     *
     */
    public void purchaseCustomizedItem() {

        while(customizedItem.size()>0) {

            for (int j = 0; j < 9; j++) {
                if(customizedItem.size() > 0)
                {
                    if (customizedItem.get(customizedItem.size() - 1).getName().compareTo(itemRecord[j].getName()) == 0) {
                        item[j].remove(item[j].size() - 1);
                        itemRecord[j].setTotalSold(itemRecord[j].getTotalSold() + 1);
                        customizedItem.remove(customizedItem.size() - 1);
                    }
                }
            }

            for (int j = 0; j < 12; j++) {
                if (customizedItem.get(customizedItem.size() - 1).equals(exclusiveItemRecord[j])) {
                    exclusiveItems[j].remove(exclusiveItems[j].size() - 1); // removes one from the arraylist
                    exclusiveItemRecord[j].setTotalSold(exclusiveItemRecord[j].getTotalSold() + 1);
                    customizedItem.remove(customizedItem.size() - 1);
                }


            }
        }
    }


    /**
     *
     * do a special transaction
     *
     * @return true of transaction is a success
     */
    public boolean doSpecialTransaction() {


        // if the customer does not have any more money
        if (this.storedCash== 0)
        {
            return false;
        }
        // if there are no new transaction
        specialCurrentTransaction = new SpecialTransaction(this.storedCash); // creates the transaction

        specialCurrentTransaction.setSelectedItems(customizedItem);

        // if the customer picks 0
        if (customizedItem.size() == 0)
        {
            this.specialCurrentTransaction.setBalance(this.storedCash);
            this.specialCurrentTransaction.setTotalAmount(0);

            ArrayList<Item> tempList = new ArrayList<>();
            Item temp = new Item("BLANK",0,0);
            tempList.add(temp);
            specialCurrentTransaction.setSelectedItems(tempList);

            transactions.add(specialCurrentTransaction);
        }
        else if ( (specialCurrentTransaction.setSelectedItems(customizedItem)))
        {
            // sets the total amount for records
            specialCurrentTransaction.setTotalAmount(this.getPriceCustomizedItem());

            // deducts the money purchase to inserted money
            specialCurrentTransaction.deductPurchase(specialCurrentTransaction.getTotalAmount());

            // adds to the vending machines total earnings
            this.totalEarnings += specialCurrentTransaction.getTotalAmount();

            // records the current Transaction
            transactions.add(specialCurrentTransaction);

            this.storedCash = this.storedCash - specialCurrentTransaction.getTotalAmount();

            this.specialCurrentTransaction.setBalance(this.storedCash);



            System.out.println("\nPrinting receipt...\n\n");

            return true;
        }
        else if (!this.isChangeEnough(this.storedCash))
        {
            System.out.println("Change is not enough... Cancelling transaction");
        }

        return false;
    }



    /**
     *
     * checks if an exclusive item is available
     *
     * @param item  the item.
     * @return true if available
     */
    public boolean isExclusiveItemAvailable(Item item)
    {

        for (int i=0;i<12;i++)
        {
            if (item.getName().compareTo(exclusiveItemRecord[i].getName())==0)
            {
                if (exclusiveItems[i].size() > 0)
                {
                    return true;
                }
            }
        }

        return false;
    }



    /**
     *
     * Gets the array of actual exclusive items
     *
     * @return the exclusive items
     */
    public ArrayList<Item>[] getExclusiveItems() {

        return exclusiveItems;
    }


    /**
     *
     * Gets the number of exclusive items in the machine
     *
     * @return the number of exclusive items in the machine
     */
    public int getCURRENTnumberOfExclusiveItems() {

        return CURRENTnumberOfExclusiveItems;
    }


    /**
     *
     * Gets record of exclusive items added in the machine
     *
     * @return the exclusive item record
     */
    public Item[] getExclusiveItemRecord() {

        return exclusiveItemRecord;
    }


    /**
     *
     * Gets the number of exclusive slots in the machine
     *
     * @return the number of exclusive slots in the machine
     */
    public int getCURRENTnumberOfExclusiveSlots() {

        return CURRENTnumberOfExclusiveSlots;
    }


    /**
     *
     * Gets the exclusive slot
     *
     * @return the exclusive slot
     */
    public ExclusiveSlot[] getExclusiveSlot() {

        return exclusiveSlot;
    }


    /**
     *
     * Gets the customized item
     *
     * @return the customized item
     */
    public ArrayList<Item> getCustomizedItem() {

        return customizedItem;
    }
}
