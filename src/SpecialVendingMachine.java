import java.util.ArrayList;

public class SpecialVendingMachine extends RegularVendingMachine{

    private ArrayList<Item>[] exclusiveItems;
    // the items that are only available for the special vending machine
    private ArrayList<Item> customizedItem;
    // arraylist of items that will be customized


    SpecialVendingMachine(String name)
    {
        super(name);
        exclusiveItems = new ArrayList[11];
        customizedItem = new ArrayList<>();
    }

    public void customizeItem()
    {
        // if an item is pushed from the given items
    }

    public void addBaseItem(String name, float calories, float price)
    {
        System.out.println("Adding base item");
    }
    // adding a base item in the machine

    public void addOtherItem(String name, float calories, float price);
    // adding another item in the machine


    public ArrayList<Item>[] getExclusiveItems() {
        return exclusiveItems;
    }
}
