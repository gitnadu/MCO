import java.util.ArrayList;

public class SpecialVendingMachine extends RegularVendingMachine{

    private ArrayList<Item>[] exsluvsiveItem = new ArrayList[11];
    //

    SpecialVendingMachine(String name)
    {
        super(name);
    }
}
