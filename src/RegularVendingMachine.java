
import java.util.ArrayList;

/**
 * The class implements a vending machine that is capable to store slots with items
 * and manage transactions of the purchase. Most of the features of the vending machine
 * is in this class.
 *
 * @author Adriel Manuel D. Fancubit
 */
public class RegularVendingMachine {

    protected String name;
    protected Slot[] slots = new Slot[9];
    protected Cash[] cash = new Cash[7];
    protected ArrayList<Item>[] item; // each vending machine has stocks of items
    protected ArrayList<Transaction> transactions;
    protected Item[] itemRecord;
    protected float totalEarnings;
    protected Transaction currentTransaction;
    protected int CURRENTnumberOfSlots;
    protected int MAXnumberOfSlots;
    protected int CURRENTnumberOfItems;

    protected float storedCash;

    protected Item selectedItem;


    /**
     *Constructs a vending machine. To construct a vending machine, its name must be specified
     *
     * @param name the name of the vending machine
     *
     */
    RegularVendingMachine(String name)
    {
        this.name = name;

        item = new ArrayList[9];
        itemRecord =  new Item [9];

        for(int i=0;i<9;i++)
        {
            item[i] = new ArrayList<Item>();
            itemRecord[i] = new Item("",0,0);
        }

        this.CURRENTnumberOfSlots = 0;
        this.CURRENTnumberOfItems = 0;
        this.totalEarnings = 0;
        MAXnumberOfSlots = 9;
        transactions = new ArrayList<>();
        cash[0] = new Cash(1);
        cash[1] = new Cash(5);
        cash[2] = new Cash(10);
        cash[3] = new Cash(20);
        cash[4] = new Cash(50);
        cash[5] = new Cash(100);
        cash[6] = new Cash(200);
        storedCash = 0;

        for (int i=0;i<7;i++)
        {
            this.cash[i].setCount(10);
            this.cash[i].setTotalValue(10 * this.cash[i].getValue());
        }

    }


    /**
     *
     * Sets the selected item
     *
     * @param selectedItem  the selected item.
     */
    public void setSelectedItem(Item selectedItem) {

        this.selectedItem = selectedItem;
    }


    /**
     *
     * Gets the selected item
     *
     * @return the selected item
     */
    public Item getSelectedItem() {

        return selectedItem;
    }


    /**
     *
     * Get the quantity of an item
     *
     * @param item  the item.
     * @return the quantity of item
     */
    public int getquantityOfItem(Item item)
    {

        for(int i=0;i<this.CURRENTnumberOfItems;i++) {
            if ((this.itemRecord[i].getName()).equalsIgnoreCase(item.getName())) {
                return this.item[i].size();
            }
        }
        return 0;
    }



    /**
     *
     * Adds an item
     *
     * @param itemName  the item name.
     * @param itemPrice  the item price.
     * @param itemCalories  the item calories.
     * @param itemQuantity  the item quantity.
     * @return boolean if successfully added
     */
    public boolean addItem(String itemName, Float itemPrice, Float itemCalories, Integer itemQuantity)
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

        for(int i=0;i<this.CURRENTnumberOfItems;i++)
        {
            // if found
            if ((this.itemRecord[i].getName()).equalsIgnoreCase(itemName))
            {
                // if empty
                if((this.item[i]).size() == 0)
                {
                    this.addStock(itemQuantity, this.itemRecord[i],i); //  supply with the original product
                    return true;
                }
                else if (((this.item[i]).size() + itemQuantity) >= 10 && ((this.item[i]).size() + itemQuantity) <= 20)
                {
                    this.addStock(itemQuantity, this.itemRecord[i],i); //  supply with the original product
                    return true;
                }
                else if (((this.item[i]).size() + itemQuantity) < 10)
                {
                    System.out.println("Restock Failure... The slot should have at least 10 items.");
                    return false;
                }
                else
                {
                    System.out.println("Restock Failure... Full stock");
                    return false;
                }

            }
        }


        Item tempItem = new Item(itemName,itemPrice,itemCalories);
        itemRecord[CURRENTnumberOfItems] = tempItem;
        itemRecord[CURRENTnumberOfItems].setSlotNumber(CURRENTnumberOfItems);

        this.addStock(itemQuantity,tempItem,this.CURRENTnumberOfItems);
        this.addSlot(tempItem,itemQuantity);
        this.CURRENTnumberOfItems += 1;

        return true;

    }



    /**
     *
     * Add stored cash
     *
     * @param money  the money.
     * @return boolean if cash if stored successfully
     */
    public boolean addStoredCash(float money)
    {

        storedCash += money; // stores the money from the customer inside the machine
        return true;
    }

    /**
     * Restocks a specific item
     *
     * @param itemName the name of the item to be restocked
     * @param itemQuantity quantity of the stock
     * @return boolean on whether the restocking is successful or not
     */


    public boolean restockItem(String itemName, int itemQuantity)
    {

        // check the if the item exists in the inventory
        for(int i=0;i<this.CURRENTnumberOfItems;i++)
        {
            // if found
            if ((this.itemRecord[i].getName()).compareTo(itemName)==0)
            {
                // if empty
                if((this.item[i]).size() == 0)
                {
                    this.addStock(itemQuantity, this.itemRecord[i],i); //  supply with the original product
                    return true;
                }
                else if (((this.item[i]).size() + itemQuantity) >= 10 && ((this.item[i]).size() + itemQuantity) <= 20)
                {
                    this.addStock(itemQuantity, this.itemRecord[i],i); //  supply with the original product
                    return true;
                }
                else if (((this.item[i]).size() + itemQuantity) < 10)
                {
                    System.out.println("Restock Failure... The slot should have at least 10 items.");
                    return false;
                }
                else
                {
                    System.out.println("Restock Failure... Full stock");
                    return false;
                }

            }
        }

        System.out.println("Error...Item not found");
        return false;
    }

    /**
     * This does the main transaction of the machine, where it loads the inserted
     * money received into the system.
     *
     * @param item item transacted
     * @return boolean on whether the transaction is a success or not
     */


    public boolean doTransaction(Item item)
    {

        // if the customer does not have any more money
        if (this.storedCash== 0)
        {
            return false;
        }
        // if there are no new transaction
        currentTransaction = new Transaction(this.storedCash); // creates the transaction

        // if the customer picks 0
        if (item.getName() == null)
        {
            this.currentTransaction.setBalance(this.storedCash);
            this.currentTransaction.setTotalAmount(0);
            Item temp = new Item("BLANK",0,0);
            this.currentTransaction.setSelectedItem(temp);

            transactions.add(currentTransaction);
        }
        else if ( (currentTransaction.selectItem(item) && this.isChangeEnough(this.storedCash-item.getPrice()) && (this.checkIfItemAvailable(item) ) ))
        {
            System.out.println("Dispensing product.....");

            // sets the total amount for records
            currentTransaction.setTotalAmount(item.getPrice());

            // deducts the money purchase to inserted money
            currentTransaction.deductPurchase(currentTransaction.getTotalAmount());

            this.purchaseItem(item.getSlotNumber()); // gets the item inside

            // adds to the vending machines total earnings
            this.totalEarnings += currentTransaction.getTotalAmount();

            // records the current Transaction
            transactions.add(currentTransaction);

            this.storedCash = this.storedCash - item.getPrice();

            this.currentTransaction.setBalance(this.storedCash);


            return true;
        }

        return false;

    }

    /**
     * Collects the total earnings of the vending machine
     *
     * @return totalEarnings the total earnings of the machine
     */

    public float collectEarnings()
    {


        float totalEarned = this.totalEarnings;

        this.totalEarnings = 0;

        return totalEarned;
    }


    /**
     *
     * Gets the current number of items inside the machine
     *
     * @return the current number of items inside the machine
     */
    public int getCURRENTnumberOfItems() {

        return CURRENTnumberOfItems;
    }


    /**
     *
     * Gets the item record
     *
     * @return the item record
     */
    public Item[] getItemRecord() {

        return itemRecord;
    }


    /**
     *
     * Gets the item
     *
     * @return the item
     */
    public ArrayList<Item>[] getItem() {

        return item;
    }


    /**
     *
     * Adds a slot
     *
     * @param item name of the item mapped in the slot
     * @param itemQuantity initial quantity of the item in the slot
     * @return boolean on whether the adding a slot was a success or not
     */

    public boolean addSlot(Item item, int itemQuantity)
    {

        // check if the slot with the item already exist

        for (int i=0;i<this.CURRENTnumberOfSlots;i++)
        {
            // if the item is already mapped with another slot
            if ((slots[i].getPrimaryItem().getName().equalsIgnoreCase(item.getName())))
            {
                addStock(itemQuantity, item,i);
                System.out.println("Since item already exists, adding stock to slot " + (i+1));
                return true;
            }
        }

        slots[CURRENTnumberOfSlots] = new Slot(item);
        this.CURRENTnumberOfSlots+=1;
        return true;
    }


    /**
     * Gets the current number of slots mapped to an item
     *
     * @return CURRENTnumberOfSlots the current number of slots mapped to an item
     */
    public int getCURRENTnumberOfSlots() {


        return CURRENTnumberOfSlots;
    }


    /**
     *
     * Gets the slot
     *
     * @param index  the index.
     * @return the slot
     */

    public Slot getSlot(int index)
    {


        return slots[index];
    }

    /**
     *
     * Gets the name of the vending machine
     *
     * @return the name of the vending machine
     */
    public String getName() {

        return name;
    }


    /**
     *
     *  Sets the stored cash in the vending machine
     *  @param storedCash amount of cash to be stored
     *
     */
    public void setStoredCash(float storedCash) {

        this.storedCash = storedCash;
    }

    /**
     *
     * Gives change in denominations
     *
     * @param money  the total amount of remaining money
     *
     * @return boolean on whether the machine successfully gives the change or not
     */

    public ArrayList<Integer> giveChange(float money)
    {

        ArrayList<Integer> arrayOfChange = new ArrayList();

        if (money > 0 && money <= 9)
        {
            while(money != 0)
            {
                if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount( (this.cash[1].getCount()) - 1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    arrayOfChange.add(5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount()) - 1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    arrayOfChange.add(1);
                    System.out.println("1-peso coin");
                }
            }
        }
        else if (money >= 10 && money <= 99)
        {
            while(money != 0)
            {
                if (money-50 >= 0 && this.cash[4].getCount() != 0)
                {
                    money -= 50;
                    this.cash[4].setCount((this.cash[4].getCount()) - 1);
                    this.cash[4].setTotalValue(this.cash[4].getCount() * 50);
                    System.out.println("50-peso bill");
                    arrayOfChange.add(50);
                }
                else if(money-20 >= 0 && this.cash[3].getCount() != 0)
                {
                    money -= 20;
                    this.cash[3].setCount((this.cash[3].getCount()) - 1);
                    this.cash[3].setTotalValue(this.cash[3].getCount() * 20);
                    System.out.println("20-peso bill");
                    arrayOfChange.add(20);
                }
                else if(money-10 >= 0 && this.cash[2].getCount() != 0)
                {
                    money -= 10;
                    this.cash[2].setCount((this.cash[2].getCount())-1);
                    this.cash[2].setTotalValue(this.cash[2].getCount() * 10);
                    arrayOfChange.add(10);
                    System.out.println("10-peso coin");
                }
                else if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount((this.cash[1].getCount())-1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    arrayOfChange.add(5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount())-1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    arrayOfChange.add(1);
                    System.out.println("1-peso coin");

                }
            }
        }
        else if (money >= 100 && money <= 500)
        {
            while(money != 0 )
            {
                if (money-500 >= 0 && this.cash[7].getCount() != 0)
                {
                    money -= 500;
                    this.cash[7].setCount((this.cash[7].getCount())-1);
                    this.cash[7].setTotalValue(this.cash[7].getCount() * 500);
                    System.out.println("500-peso bill");
                    arrayOfChange.add(500);
                }
                else if (money-200 >= 0 && this.cash[6].getCount() != 0)
                {
                    money -= 200;
                    this.cash[6].setCount((this.cash[6].getCount())-1);
                    this.cash[6].setTotalValue(this.cash[6].getCount() * 200);
                    System.out.println("200-peso bill");
                    arrayOfChange.add(200);
                }
                else if (money-100 >= 0 && this.cash[5].getCount() != 0)
                {
                    money -= 100;
                    this.cash[5].setCount((this.cash[5].getCount())-1);
                    this.cash[5].setTotalValue(this.cash[5].getCount() * 100);
                    System.out.println("100-peso bill");
                    arrayOfChange.add(100);
                }
                else if (money-50 >= 0 && this.cash[4].getCount() != 0)
                {
                    money -= 50;
                    this.cash[4].setCount((this.cash[4].getCount())-1);
                    this.cash[4].setTotalValue(this.cash[4].getCount() * 50);
                    arrayOfChange.add(50);

                    System.out.println("50-peso bill");
                }
                else if(money-20 >= 0 && this.cash[3].getCount() != 0)
                {
                    money -= 20;
                    this.cash[3].setCount((this.cash[3].getCount())-1);
                    this.cash[3].setTotalValue(this.cash[3].getCount() * 20);
                    arrayOfChange.add(20);
                    System.out.println("20-peso coin");
                }
                else if(money-10 >= 0 && this.cash[2].getCount() != 0)
                {
                    money -= 10;
                    this.cash[2].setCount((this.cash[2].getCount())-1);
                    this.cash[2].setTotalValue(this.cash[2].getCount() * 10);
                    arrayOfChange.add(10);
                    System.out.println("10-peso coin");
                }
                else if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount((this.cash[1].getCount())-1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    arrayOfChange.add(5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount())-1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    arrayOfChange.add(1);
                    System.out.println("1-peso coin");
                }
            }
        }
        else if (money == 0)
        {
            arrayOfChange.add(0);
        }

        return arrayOfChange;
    }


    /**
     *
     * Gets the cash in different denominations
     *
     * @return cash the cash
     */
    public Cash[] getCash(){


        return cash;
    }


    /**
     *
     * Gets the stored cash
     *
     * @return the stored cash
     */
    public float getStoredCash() {

        return storedCash;
    }

    /**
     *
     * Checks if the machine can dish out denominations of cash with the given amount
     * to check if giving change is possible after the purchase
     *
     * @param money the given amount
     * @return boolean if it can give change or not
     */

    public boolean isChangeEnough(float money)
    {

        int countOfEach[] =  new int[7];

        for(int i = 0;i<7;i++)
        {
            countOfEach[i] = this.cash[i].getCount();
        }

        if (money > 0 && money <= 9)
        {
            while(money != 0)
            {
                if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    countOfEach[1] -= 1;
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    countOfEach[1] -= 1;
                }
            }
        }
        else if (money >= 10 && money <= 99)
        {
            while(money != 0)
            {
                if (money-50 >= 0)
                {
                    money -= 50;
                    countOfEach[4] -= 1;
                }
                else if(money-20 >= 0)
                {
                    money -= 20;
                    countOfEach[3] -= 1;
                }
                else if(money-10 >= 0)
                {
                    money -= 10;
                    countOfEach[2] -= 1;
                }
                else if (money-5 >= 0)
                {
                    money -= 5;
                    countOfEach[1] -= 1;
                }
                else if(money-1 >= 0)
                {
                    money --;
                    countOfEach[0] -= 1;
                }
            }
        }
        else if (money >= 100 && money <= 500)
        {
            while(money != 0 )
            {
                if (money-200 >= 0)
                {
                    money -= 200;
                    countOfEach[6] -= 1;
                }
                else if (money-100 >= 0)
                {
                    money -= 100;
                    countOfEach[5] -= 1;
                }
                else if (money-50 >= 0)
                {
                    money -= 50;
                    countOfEach[4] -= 1;
                }
                else if(money-20 >= 0)
                {
                    money -= 20;
                    countOfEach[3] -= 1;
                }
                else if(money-10 >= 0)
                {
                    money -= 10;
                    countOfEach[2] -= 1;
                }
                else if (money-5 >= 0)
                {
                    money -= 5;
                    countOfEach[1] -= 1;
                }
                else if(money-1 >= 0)
                {
                    money --;
                    countOfEach[0] -= 1;
                }
            }
        }

        for(int i = 0;i<7;i++)
        {
            if (countOfEach[i] < 0)
                return false;
        }

        return true;

    }



    /**
     *
     * Add stock
     *
     * @param stockQuantity  the stock quantity.
     * @param item  the item.
     * @param index  the index.
     */
    public void addStock(int stockQuantity, Item item, int index)
    {


        for(int j = 0;j<stockQuantity;j++) {
            this.item[index].add(item);
        }

    }



    /**
     *
     * Check if item available
     *
     * @param item  the item.
     * @return boolean
     */
    public boolean checkIfItemAvailable(Item item)
    {

        // find the item in the inventory
        for (int i=0;i<this.CURRENTnumberOfItems;i++)
        {
            // if the item is found
            if (this.itemRecord[i].getName().equalsIgnoreCase(item.getName()))
            {
                if (this.item[i].size() > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        return false;
    }

    /**
     *
     * Represents the dispenser of the slot. Adds the tally of the total
     * number of items sold by that slot.
     *
     */

    public void purchaseItem(int slotNumber)
    {

        this.item[slotNumber].remove(this.item[slotNumber].size()-1);
        this.itemRecord[slotNumber].setTotalSold(this.itemRecord[slotNumber].getTotalSold() + 1);
    }
}
