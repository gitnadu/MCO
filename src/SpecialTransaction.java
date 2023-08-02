import java.util.ArrayList;

/**
 * This class implements a special transaction, that made purchasing items in the vending machine
 * possible. It includes its remaining balance (balance), its arraylist of selected items and the
 * total amount of the transaction.
 *
 * @author Adriel Manuel D. Fancubit
 */

public class SpecialTransaction extends Transaction{

    private ArrayList<Item> selectedItems;
    /**
     * Constructs a sepcial transaction. To construct a transaction, a certain amount of money
     * must be provided.
     *
     *
     *
     */

    SpecialTransaction(float money)
    {
        super(money);
    }


    /**
     *
     * Compared to the Transaction class, special Transaction
     * sets an arraylist of selected items
     *
     * @param ArrayList<Item> arraylist of selected Items
     */
    public boolean setSelectedItems(ArrayList<Item> selectedItems) {
        this.selectedItems = selectedItems;
        return true;
    }
}
