import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpecialVendingMachine extends RegularVendingMachine{

    private ArrayList<Item>[] exclusiveItems = new ArrayList[12];
    private Item[] exclusiveItemRecord =  new Item[12];
    private ExclusiveSlot[] exclusiveSlot = new ExclusiveSlot[12];
    private int CURRENTnumberOfExclusiveItems;
    private int CURRENTnumberOfExclusiveSlots;
    private int CURRENTnumberOfItemstobeCustomized;
    // the items that are only available for the special vending machine
    private ArrayList<Item> customizedItem;
    // arraylist of items that will be customized


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
        CURRENTnumberOfItemstobeCustomized = 0;
    }

    public void customizeItem()
    {
        // if an item is pushed from the given items
    }

    public boolean addBaseItem(String itemName ,float itemPrice, float itemCalories,  int itemQuantity)
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

        exclusiveSlot[CURRENTnumberOfExclusiveSlots].setPrimaryItem(tempItem);

        CURRENTnumberOfExclusiveItems++;
        CURRENTnumberOfExclusiveSlots++;

        return true;
    }
    // adding a base item in the machine

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

        CURRENTnumberOfExclusiveItems += 1;
        CURRENTnumberOfExclusiveSlots += 1;

        return true;
    }
    // adding another item in the machine


    public boolean customizingItem(Item item)
    {

        if (isExclusiveItemAvailable(item))
        {
            customizedItem.add(item);
            CURRENTnumberOfItemstobeCustomized++;
            return true;
        }
        return false;
    }

    public void getCaloriesCustomizedItem()
    {
        float sum = 0;
        // iterates over the calories of each item
        for(int i = 0; i <customizedItem.size();i++)
        {
            sum += customizedItem.get(i).getCalories();
        }
    }

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


    public void purchaseCustomizedItem() {

        for (int i=0;i<12;i++)
        {
            if (customizedItem.get(CURRENTnumberOfItemstobeCustomized-1).equals(exclusiveItemRecord[i]))
            {
                exclusiveItems[i].remove(exclusiveItems[i].size()-1); // removes one from the arraylist
                if (CURRENTnumberOfItemstobeCustomized != 0)
                {
                    CURRENTnumberOfItemstobeCustomized--;
                }
            }
        }
        customizedItem.clear(); // this clears the customized items
    }

    public boolean doSpecialTransaction() {

        // if the customer does not have any more money
        if (this.storedCash== 0)
        {
            return false;
        }
        // if there are no new transaction
        SpecialTransaction currentTransaction = new SpecialTransaction(this.storedCash); // creates the transaction

        currentTransaction.setSelectedItems(customizedItem);

        // if the customer picks 0
        if (customizedItem.size() == 0)
        {
            this.currentTransaction.setBalance(this.storedCash);
            this.currentTransaction.setTotalAmount(0);

            ArrayList<Item> tempList = new ArrayList<>();
            Item temp = new Item("BLANK",0,0);
            tempList.add(temp);
            currentTransaction.setSelectedItems(tempList);

            transactions.add(currentTransaction);
        }
        else if ( (currentTransaction.setSelectedItems(customizedItem) && this.isChangeEnough(this.storedCash) )  )
        {
            // sets the total amount for records
            currentTransaction.setTotalAmount(this.getPriceCustomizedItem());

            // deducts the money purchase to inserted money
            currentTransaction.deductPurchase(currentTransaction.getTotalAmount());

            this.purchaseCustomizedItem(); // gets the item inside

            // adds to the vending machines total earnings
            this.totalEarnings += currentTransaction.getTotalAmount();

            // records the current Transaction
            transactions.add(currentTransaction);

            this.storedCash = this.storedCash - currentTransaction.getTotalAmount();

            this.currentTransaction.setBalance(this.storedCash);

            System.out.println("\nPrinting receipt...\n\n");
            this.currentTransaction.printReceipt();

            return true;
        }
        else if (!this.isChangeEnough(this.storedCash))
        {
            System.out.println("Change is not enough... Cancelling transaction");
        }

        return false;
    }

    public boolean isExclusiveItemAvailable(Item item)
    {
        for (int i=0;i<12;i++)
        {
            if (item.equals(exclusiveItems[i]))
            {
                if (exclusiveItems[i].size() > 0)
                {
                    return true;
                }
            }
        }

        return false;
    }


    public ArrayList<Item>[] getExclusiveItems() {
        return exclusiveItems;
    }

    public int getCURRENTnumberOfExclusiveItems() {
        return CURRENTnumberOfExclusiveItems;
    }

    public Item[] getExclusiveItemRecord() {
        return exclusiveItemRecord;
    }

    public ExclusiveSlot[] getExclusiveSlot() {
        return exclusiveSlot;
    }

    public ArrayList<Item> getCustomizedItem() {
        return customizedItem;
    }
}
