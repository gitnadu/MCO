import java.util.ArrayList;

public class SpecialVendingMachine extends RegularVendingMachine{

    private ArrayList<Item>[] exclusiveItems;
    private int CURRENTnumberOfExclusiveItems;
    // the items that are only available for the special vending machine
    private ArrayList<Item> customizedItem;
    // arraylist of items that will be customized


    SpecialVendingMachine(String name)
    {
        super(name);
        exclusiveItems = new ArrayList[11];
        customizedItem = new ArrayList<>();
        CURRENTnumberOfExclusiveItems = 0; // no exclusive items in the machine
    }

    public void customizeItem()
    {
        // if an item is pushed from the given items
    }

    public void addBaseItem(String name, float calories, float price)
    {
        System.out.println("Adding base item");
        BaseItem item = new BaseItem(name,calories,price);

        exclusiveItems[CURRENTnumberOfExclusiveItems].add(item); // adds the items to the
    }
    // adding a base item in the machine

    public void addOtherItem(String name, float calories, float price)
    {
        System.out.println("Adding base item");
        DependentItem item = new DependentItem(name,calories,price);

        exclusiveItems[CURRENTnumberOfExclusiveItems].add(item); // adds the items to the
    }
    // adding another item in the machine


    public void customizingItem(Item item)
    {
        System.out.println("Adding item");
        customizedItem.add(item);
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

    public void getPriceCustomizedItem()
    {
        float sum = 0;
        // iterates over the price of each item
        for(int i = 0; i <customizedItem.size();i++)
        {
            sum += customizedItem.get(i).getPrice();
        }
    }


    public ArrayList<Item> purchaseCustomizedItem() {

        ArrayList<Item> temp = new ArrayList<Item>();
        for(int i = 0; i <customizedItem.size();i++)
        {
            temp.add(customizedItem.get(i));
        }
        customizedItem.clear(); // this clears the customized items

        return temp;
    }

    public ArrayList<Item>[] getExclusiveItems() {
        return exclusiveItems;
    }

    public int getCURRENTnumberOfExclusiveItems() {
        return CURRENTnumberOfExclusiveItems;
    }
}
