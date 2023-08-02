import java.util.ArrayList;

public class SpecialTransaction extends Transaction{

    private ArrayList<Item> selectedItems;
    SpecialTransaction(float money)
    {
        super(money);
    }

    public boolean setSelectedItems(ArrayList<Item> selectedItems) {
        this.selectedItems = selectedItems;
        return true;
    }
}
