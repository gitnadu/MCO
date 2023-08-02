/**

 * This class extends Item object, which will serve as the item that can be added for customizing, but
 * cant be bought by itself
 *
 * @author Adriel Manuel D. Fancubit
 *
 */
public class DependentItem extends Item{

    /**
     *
     * Constructs a dependentitem object, with its given name, its price and its calories
     *
     * @param name the name of the item
     * @param calories the calories of the item
     * @param price the price of the item
     */
    DependentItem(String name, float calories, float price)
    {
        super( name, calories,price);
    }
}
