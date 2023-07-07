

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The class implements a vending machine that is capable to store slots with items
  * and manage transactions of the purchase. Most of the features of the vending machine
  * is in this class.
  *
  * @author Adriel Manuel D. Fancubit
 */ 
public class VendingMachine {

    private String name;
    private Slot[] slots;
    private Cash[] cash = new Cash[8];
    private ArrayList<Item>[] item; // each vending machine has stocks of items
    private Item[] itemRecord;
    private float totalEarnings;
    private Transaction currentTransaction;
    private int MAXnumberOfSlots;
    private int CURRENTnumberOfSlots;
    private ArrayList<Transaction> transactions;
    private int CURRENTnumberOfItems;


     /**
      *Constructs a vending machine. To construct a vending machine, the max
      *number of slots and its name must be specified
      *
      * @param MAXnumberOfSlots the max number of slots
      * @param name the name of the vending machine
      *
      */
    VendingMachine(int MAXnumberOfSlots, String name)
    {
        this.name = name;
        item = new ArrayList[20];
        itemRecord =  new Item [20];
        this.MAXnumberOfSlots = MAXnumberOfSlots;
        this.CURRENTnumberOfSlots = 0;
        this.CURRENTnumberOfItems = 0;
        this.totalEarnings = 0;
        transactions = new ArrayList<>();
        slots = new Slot[MAXnumberOfSlots]; // instantiates an array for the slots
        cash[0] = new Cash(1);
        cash[1] = new Cash(5);
        cash[2] = new Cash(10);
        cash[3] = new Cash(20);
        cash[4] = new Cash(50);
        cash[5] = new Cash(100);
        cash[6] = new Cash(200);
        cash[7] = new Cash(500);

        for (int i=0;i<8;i++)
        {
            this.cash[i].setCount(10);
            this.cash[i].setTotalValue(10 * this.cash[i].getValue());
        }
        
    }
    
    /**
     * Restocks the specific item
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
            if ((this.itemRecord[i].getName()).equalsIgnoreCase(itemName))
            {
                // if empty
                if((this.item[i]).size() == 0)
                {
                    this.addStock(itemQuantity, this.itemRecord[i]); //  supply with the original product
                    return true;
                }
                else if (((this.item[i]).size() + itemQuantity) >= 10 && ((this.item[i]).size() + itemQuantity) <= 20)
                {
                    this.addStock(itemQuantity, this.itemRecord[i]); //  supply with the original product
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
     * Sets a new price of a specific item
     *
     * @param price the new price
     * @param name the name of item
     * @return boolean on whether setting the new price is successful or not
     */


    public boolean setNewPrice(float price, String name) 
    {
        // find the item in the vending machine
        for(int i=0;i<this.CURRENTnumberOfItems;i++)
        {
            // if found
            if (this.itemRecord[i].getName().equalsIgnoreCase(name))
            {
                // if there are no items in the machine
                if ((this.item[i].size()) == 0)
                {
                    return false;
                }

                // sets the new price of the item inside the machine
                for (int j=0; j<(this.item[i]).size() ;j++)
                {
                    (this.item[i]).get(j).setPrice(price);
                }

                return true;
            }
        }

        return false;
        
    }
    
    /**
     * This does the main transaction of the machine, where it loads the inserted
     * money received into the system.
     *
     * @param money inserted money through the machine
     * @return boolean on whether the transaction is a success or not
     */

    public boolean doTransaction(float money) 
    {

        Scanner sc = new Scanner(System.in);
        int slotNumber;

        // if the customer does not have any more money
        if (money == 0)
        {
            System.out.println("No more money...");
            return false;
        }

        // if there are no new transaction
        currentTransaction = new Transaction(money); // creates the transaction
        
        System.out.println("CURRENT BALANCE: " + this.currentTransaction.getBalance());
        System.out.println("Slot [0] Cancel");
        this.displaySlots();
        System.out.println("What would you like to buy?");
        System.out.print(">> ");
        slotNumber = sc.nextInt();

        while(slotNumber < 0 && slotNumber > this.CURRENTnumberOfSlots)
        {
            System.out.println("Error... Empty slot");
            System.out.print(">> ");
            slotNumber = sc.nextInt();
            sc.nextLine();
        }
        //
        if (slotNumber!= 0)
        {
            money = money - this.getSlot(slotNumber-1).getPrimaryItem().getPrice();
        }
        // if the customer picks 0
        if (slotNumber == 0)
        {
            this.currentTransaction.setBalance(money);
            this.currentTransaction.setTotalAmount(0);
            Item temp = new Item("BLANK",0,0);
            this.currentTransaction.setSelectedItem(temp);

            transactions.add(currentTransaction);
            System.out.println("Printing Receipt...");
            this.currentTransaction.printReceipt();

        }
        else if (slotNumber != 0 & !(this.checkIfItemAvailable(this.getSlot(slotNumber-1).getPrimaryItem())))
        {
            System.out.println("Item out of stock...");
        }
        else if (( slotNumber != 0 && currentTransaction.selectItem(this.getSlot(slotNumber-1).getPrimaryItem()) && this.isChangeEnough(money) && (this.checkIfItemAvailable(this.getSlot(slotNumber-1).getPrimaryItem()))))
        {
            System.out.println("Dispensing product.....");
            
            // sets the total amount for records
            currentTransaction.setTotalAmount(this.getSlot(slotNumber-1).getPrimaryItem().getPrice());
            
            // deducts the money purchase to inserted money
            currentTransaction.deductPurchase(currentTransaction.getTotalAmount());

            this.purchaseItem(slotNumber); // gets the item inside

            // adds to the vending machines total earnings
            this.totalEarnings += currentTransaction.getTotalAmount();

            // records the current Transaction
            transactions.add(currentTransaction);

            System.out.println("\nPrinting receipt...\n\n");
            this.currentTransaction.printReceipt();

            return true;
        }
        else if (!currentTransaction.selectItem(this.getSlot(slotNumber-1).getPrimaryItem()))
        {
            System.out.println("Insufficient funds... Please insert more money.");
        }
        else if (!this.isChangeEnough(money))
        {
            System.out.println("Change is not enough... Cancelling transaction");
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

        float totalEarnings = this.totalEarnings;

        this.giveChange(totalEarnings);
        this.totalEarnings = 0;
        
        return totalEarnings;
    }

    /**
     * Removes a specific slot
     *
     * @param slotNumber number of the slot to be removed
     * @return boolean on whether removing a slot was a success or not
     */

    public boolean removeSlot(int slotNumber) 
    {
        // if the slot to be removed is the current max number of slots
        if (slotNumber == CURRENTnumberOfSlots)
        {
            this.slots[CURRENTnumberOfSlots] = null;
            CURRENTnumberOfSlots--;
            return true;
        }
        else if (CURRENTnumberOfSlots == MAXnumberOfSlots)
        {
            // if the slot is full
            this.slots[slotNumber-1] = null;
            for(int i= slotNumber-1;i<CURRENTnumberOfSlots;i++)
            {
                this.slots[i].anotherSlot(this.slots[i+1]);
            }
            CURRENTnumberOfSlots--;
            return true;
        }
        else
        {
            for(int i= slotNumber-1;i<CURRENTnumberOfSlots;i++)
            {
            this.slots[i].anotherSlot(this.slots[i+1]);
            }
            this.slots[CURRENTnumberOfSlots] = null;
            CURRENTnumberOfSlots--;
            return true;
        }

        
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
                addStock(itemQuantity, item);
                System.out.println("Since item already exists, adding stock to slot " + (i+1));
                return true;
            }
        }

        slots[CURRENTnumberOfSlots] = new Slot(item, itemQuantity);
        this.CURRENTnumberOfSlots+=1;
        return true;
    }

/** 
 *
 * This display the existing slots of the vending machine
 *
 */
    public void displaySlots(){ 

        for (int i = 0 ;i<this.CURRENTnumberOfSlots;i++)
        {
            if (this.checkIfItemAvailable(this.slots[i].getPrimaryItem()))
            {
                System.out.println("Slot [" + (i+1) + "] " + ( this.getSlot(i) ).getPrimaryItem().getName() + "     Remaining: "+ (this.getSlot(i)).getTotalRemainingItem() + "      Calories: " + (this.getSlot(i)).getPrimaryItem().getCalories() + "        Price: " + (this.getSlot(i)).getPrimaryItem().getPrice() );
            }
            else
            {
                System.out.println("Slot [" + (i+1) + "] " + "OUT OF STOCK");
            }
            
        } 
    }

    /**
     * Gets the max number of slots
     *
     * @return MAXnumberOfSlots the max number of slots
     */
    public int getMAXnumberOfSlots() { 

        return MAXnumberOfSlots;
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
     * Displays the transaction history of the vending machine
     *
     */
    public void displayTransactionHistory() 
    {

        if (transactions.size() > 0)
        {
            for(int i=0;i<transactions.size();i++)
            {
                System.out.println("Transaction number: " + (i+1) + "       Item:" +(transactions.get(i).getSelectedItem()).getName() + "      TOTAL AMOUNT: " + (transactions.get(i).getTotalAmount()));
            }
            
            System.out.println("Total items sold per slot: ");

            for(int i=0;i< this.CURRENTnumberOfSlots ;i++)
            {   
                System.out.println("Slot "+ (i+1) +"        Item: "+ ((this.getSlot(i)).getPrimaryItem().getName()) + "     Total Sold: " + (this.getSlot(i)).getTotalSold() );
            }

            System.out.println("Total Claimable Earnings: " + totalEarnings);

        }
        else
        {
            System.out.println("No recorded transactions...");
        }
    }



    /**
     *
     * Gets the current transaction of the vending machine
     *
     * @return the current transaction of the vending machine
     */
    public Transaction getCurrentTransaction() { 

        return currentTransaction;
    }

    /**
     *
     * Sets the current transaction of the vending machine
     *
     * @param currentTransaction
     */
    public void setCurrentTransaction(Transaction currentTransaction) { 

        this.currentTransaction = currentTransaction;
    }
    /**
     *
     * Gives change in denominations
     *
     * @param money  the total amount of remaining money
     *
     * @return boolean on whether the machine successfully gives the change or not
     */
    public boolean giveChange(float money) 
    {

        if (money > 0 && money <= 9)
        {
            while(money != 0)
            {
                if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount( (this.cash[1].getCount()) - 1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount()) - 1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    System.out.println("1-peso coin");
                }
            }
            return true;
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
                }
                else if(money-20 >= 0 && this.cash[3].getCount() != 0)
                {
                    money -= 20;
                    this.cash[3].setCount((this.cash[3].getCount()) - 1);
                    this.cash[3].setTotalValue(this.cash[3].getCount() * 20);
                    System.out.println("20-peso bill");
                }
                else if(money-10 >= 0 && this.cash[2].getCount() != 0)
                {
                    money -= 10;
                    this.cash[2].setCount((this.cash[2].getCount())-1);
                    this.cash[2].setTotalValue(this.cash[2].getCount() * 10);
                    System.out.println("10-peso coin");
                }
                else if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount((this.cash[1].getCount())-1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount())-1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    System.out.println("1-peso coin");
                }
            }
            return true;
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
                }
                else if (money-200 >= 0 && this.cash[6].getCount() != 0)
                {
                    money -= 200;
                    this.cash[6].setCount((this.cash[6].getCount())-1);
                    this.cash[6].setTotalValue(this.cash[6].getCount() * 200);
                    System.out.println("200-peso bill");
                }
                else if (money-100 >= 0 && this.cash[5].getCount() != 0)
                {
                    money -= 100;
                    this.cash[5].setCount((this.cash[5].getCount())-1);
                    this.cash[5].setTotalValue(this.cash[5].getCount() * 100);
                    System.out.println("100-peso bill");
                }
                else if (money-50 >= 0 && this.cash[4].getCount() != 0)
                {
                    money -= 50;
                    this.cash[4].setCount((this.cash[4].getCount())-1);
                    this.cash[4].setTotalValue(this.cash[4].getCount() * 50);

                    System.out.println("50-peso bill");
                }
                else if(money-20 >= 0 && this.cash[3].getCount() != 0)
                {
                    money -= 20;
                    this.cash[3].setCount((this.cash[3].getCount())-1);
                    this.cash[3].setTotalValue(this.cash[3].getCount() * 20);
                    System.out.println("20-peso coin");
                }
                else if(money-10 >= 0 && this.cash[2].getCount() != 0)
                {
                    money -= 10;
                    this.cash[2].setCount((this.cash[2].getCount())-1);
                    this.cash[2].setTotalValue(this.cash[2].getCount() * 10);
                    System.out.println("10-peso coin");
                }
                else if (money-5 >= 0 && this.cash[1].getCount() != 0)
                {
                    money -= 5;
                    this.cash[1].setCount((this.cash[1].getCount())-1);
                    this.cash[1].setTotalValue(this.cash[1].getCount() * 5);
                    System.out.println("5-peso coin");
                }
                else if(money-1 >= 0 && this.cash[0].getCount() != 0)
                {
                    money --;
                    this.cash[0].setCount((this.cash[0].getCount())-1);
                    this.cash[0].setTotalValue(this.cash[0].getCount());
                    System.out.println("1-peso coin");
                }
            }
            return true;
        }

        return false;
    }


    /**
     *
     * Adds different denominations of cash into the vending machine system
     *
     */
    public void addCash() 
    {

        Scanner sc = new Scanner(System.in);

        int tobeAddedCash;
        int tobeAddedCashCount;

        System.out.println("You can only add 5, 10, 20 coins OR 50, 100, 200 and 500 bills");
        System.out.println("What bill/coin would you like to add? ");
        System.out.println("[1] 1-peso coin");
        System.out.println("[2] 5-peso coin");
        System.out.println("[3] 10-peso coin");
        System.out.println("[4] 20-peso coin");
        System.out.println("[5] 50-peso bill");
        System.out.println("[6] 100-peso bill");
        System.out.println("[7] 200-peso bill");
        System.out.println("[8] 500-peso bill");
        System.out.print(">> ");
        tobeAddedCash = sc.nextInt();
        sc.nextLine();
        System.out.println("\nReminder: You can only add up to 100 coins or 50 bills");
        System.out.print("How Many? ");
        tobeAddedCashCount = sc.nextInt();
        sc.nextLine();
        if ( tobeAddedCash > 0 && tobeAddedCash < 5)
        {
            while (tobeAddedCashCount > 100 || tobeAddedCashCount <= 0)
            {
            System.out.println("Invalid... You can only add up to 100 coins");
            System.out.print("How Many? ");
            tobeAddedCashCount = sc.nextInt();
            sc.nextLine();
            }
        }

        if (tobeAddedCash > 4 && tobeAddedCash < 9)
        {
            while (tobeAddedCashCount > 50 || tobeAddedCashCount <= 0)
            {
            System.out.println("Invalid... You can only add up to 50 bills");
            System.out.print("How Many? ");
            tobeAddedCashCount = sc.nextInt();
            sc.nextLine();
            }
        }
        
        
        this.addCashCount(tobeAddedCash, tobeAddedCashCount); // adds the cash

    }
        

    /**
     *
     * This a helper class that adds the count to the cash of the given value
     *
     * @param index  the index of the cash
     * @param count  the count to be supplied
     */
    private void addCashCount(int index, int count) 
    {

        switch(index)
        {
            case 1:
            {
                this.cash[0].setCount(this.cash[0].getCount() + count);
                this.cash[0].setTotalValue(this.cash[0].getTotalValue() + 1);
                break;
            }
            case 2:
            {
                this.cash[1].setCount(this.cash[1].getCount() + count);
                this.cash[1].setTotalValue(this.cash[1].getTotalValue() + 5);
                break;
            }

            case 3:
            {
                this.cash[2].setCount(this.cash[2].getCount() + count);
                this.cash[2].setTotalValue(this.cash[2].getTotalValue() + 10);
                break;
            }

            case 4:
            {
                this.cash[3].setCount(this.cash[3].getCount() + count);
                this.cash[3].setTotalValue(this.cash[3].getTotalValue() + 20);
                break;
            }

            case 5:
            {
                this.cash[4].setCount(this.cash[4].getCount() + count);
                this.cash[4].setTotalValue(this.cash[4].getTotalValue() + 50);
                break;
            }
            case 6:
            {
                this.cash[5].setCount(this.cash[5].getCount() + count);
                this.cash[5].setTotalValue(this.cash[5].getTotalValue() + 100);
                break;
            }
            case 7:
            {
                this.cash[6].setCount(this.cash[6].getCount() + count);
                this.cash[6].setTotalValue(this.cash[6].getTotalValue() + 200);
                break;
            }
            case 8:
            {
                this.cash[7].setCount(this.cash[7].getCount() + count);
                this.cash[7].setTotalValue(this.cash[7].getTotalValue() + 500);
                break;
            }
        }
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
     * Prints cash, including its value and count
     *
     */
    public void printCash() 
    {

        for(int i=0;i<8;i++)
        {
            System.out.println("Value " + this.cash[i].getValue() + " - " + this.cash[i].getCount());    
        }
    }


    /**
     *
     * Processes the inserted money
     *
     * @param totalCash  the total cash.
     * @return the inserted money
     */
    public float getInsertedMoney(float totalCash) 
    {

        Scanner sc = new Scanner(System.in);
        float minPrice;
        float cash = 0;
        int startingValue = 0;

        // get the minimum price from available slots
        while((this.getSlot(startingValue).getTotalRemainingItem()) == 0)
        {
            startingValue++;
        }

        minPrice = (this.getSlot(startingValue)).getPrimaryItem().getPrice();
        
        for(int i=startingValue+1;i<this.getCURRENTnumberOfSlots();i++)
        {
            if ( (this.getSlot(startingValue).getTotalRemainingItem() ) != 0) // denotes it is available
            {
                if ( this.getSlot(i).getPrimaryItem().getPrice() < minPrice)
                {
                    minPrice = this.getSlot(i).getPrimaryItem().getPrice();
                }
            }
        }
        totalCash = 0;
        System.out.println("\n Reminder: This machine only takes 5, 10, 20 peso coin or");
        System.out.println("50, 100, 200 and 500 peso bill");
        System.out.print("\nInsert Money: ");
        cash = sc.nextFloat(); // remove \n
        sc.nextLine();

        while(cash != 5 && cash != 10 && cash != 20 && cash != 50 && cash != 100 && cash != 200 && cash != 500)
        {
            System.out.println("Error... Invalid money");
            System.out.print("\nInsert Money: ");
            cash = sc.nextFloat(); // remove \n
            sc.nextLine();
        }
                    
        System.out.println("Inserting Money...");
        totalCash += cash;

        for(int i = 0; i < 8 ; i++)
        {
            if (cash == this.cash[i].getValue())
            {
                this.addCashCount(i+1,1);
                this.cash[i].setTotalValue(this.cash[i].getCount() * this.cash[i].getValue());
                i = 8;
            }
        }
        

        while(totalCash < minPrice)
        {
            System.out.println("Money insufficient...");
            System.out.print("\nInsert Money: ");
            cash = sc.nextFloat(); // remove \n
            sc.nextLine();
            
            while(cash != 5 && cash != 10 && cash != 20 && cash != 50 && cash != 100 && cash != 200 && cash != 500)
            {
                System.out.println("Error... Invalid money");
                System.out.print("\nInsert Money: ");
                cash = sc.nextFloat(); // remove \n
                sc.nextLine();
            }

            totalCash += cash;

            for(int i = 0; i < 8 ; i++)
            {
                if (cash == this.cash[i].getValue())
                {
                    this.addCashCount(i+1,1);
                    this.cash[i].setTotalValue(this.cash[i].getCount() * this.cash[i].getValue());
                    i = 8;
                }
            }
        }
        return totalCash;
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
        int countOfEach[] =  new int[8];

        for(int i = 0;i<8;i++)
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
                if (money-500 >= 0)
                {
                    money -= 500;
                    countOfEach[7] -= 1;
                }
                else if (money-200 >= 0)
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

        for(int i = 0;i<8;i++)
        {
            if (countOfEach[i] < 0)
                return false;
        }

        return true;
        
    }

    public void addStock(int stockQuantity, Item item)
    {
        // finding the item in the vending machine
        for(int j=0;j<CURRENTnumberOfItems;j++)
        {
            // if the item is found
            if (this.itemRecord[j].getName().equalsIgnoreCase(item.getName()))
            {
                for (int i=0;i<stockQuantity;i++)
                {
                    if (this.item[i].size() + 1 <= 20)
                    {
                        this.item[i].add(item);
                    }
                    else
                    {
                        System.out.println("Reached maximum stock... Stopping.");
                        i = stockQuantity; // stops the stocking
                    }
                }

            }



        }

    }

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
                } else
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
        this.item[slotNumber-1].remove(this.item[slotNumber-1].size()-1);
        this.slots[slotNumber-1].setTotalSold(this.slots[slotNumber-1].getTotalSold() + 1);
    }
}
