

/**
 * This class implements a transaction, that made purchasing items in the vending machine
 * possible. It includes its remaining balance (balance), its selected item and the 
 * total amount of the transaction.
 * 
 * @author Adriel Manuel D. Fancubit
 */
public class Transaction {

    private float balance;
    private Item selectedItem;
    private float totalAmount;

    /**
     * Constructs a transaction. To construct a transaction, a certain amount of money
     * must be provided.
     *
     * @param money amount of money to be used in a transaction
     *
     */
    Transaction(float money) {
        this.balance = money;
        this.totalAmount = 0;

    }

    /**
     *
     * Prints receipt of the transaction
     *
     */
    public void printReceipt()
    {

        if ((this.getSelectedItem()) != null)
        {
            System.out.println("ITEM: " + (this.getSelectedItem()).getName());
            System.out.println("Price: " + this.totalAmount);
        }
        else
        {
            System.out.println("ITEM: BLANK");
            System.out.println("Price: ---");
            System.out.println("Change: " + this.balance);
        }

    }


    /**
     * Checking if the balance of the transaction is enough and the slot is available
     * before setting the selected item of the transaction
     *
     * @param item the selected item
     * @param slot the selected slot
     * @return boolean if the selected item is available and can be purchased with the money
     */

    public boolean selectItem(Item item)
    {

        if (item.getPrice() <= this.balance)
        {
            this.selectedItem = item;
            return true;
        }
        else
            return false;

    }

    /**
     *
     * Sets the selected Item of the Transaction
     *
     */
    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     *
     * Gets the balance of the transaction
     *
     * @return balance the balance of the transaction
     */
    public float getBalance() {

        return balance;
    }


    /**
     *
     * Gets the selected item in the transaction
     *
     * @return selectedItem the selected item
     */
    public Item getSelectedItem() {

        return selectedItem;
    }

    /**
     *
     * Gets the total amount of the transaction
     * @return totalAmount the total amount of the transaction
     */
    public float getTotalAmount() {

        return totalAmount;
    }

    /**
     *
     * Sets the total amount of the transaction
     *
     * @param totalAmount
     */
    public void setTotalAmount(float totalAmount) {

        this.totalAmount = totalAmount;
    }

    /**
     *
     * Deducts the purchase to the balance of the transaction
     *
     * @param money
     */

    public void deductPurchase(float money)
    {
        this.balance -= money;
    }

    /**
     *
     * Sets the balance of the transaction
     *
     * @param balance
     */
    public void setBalance(float balance) {

        this.balance = balance;
    }

}
