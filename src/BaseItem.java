/**

 * This class extends Item object, which will serve as the item to be based on for customizing
 * a product
 *
 * @author Adriel Manuel D. Fancubit
 *
 */

public class BaseItem extends Item{

    /**
     *
     * Constructs a baseitem object, with its given name, its price and its calories
     *
     * @param name the name of the item
     * @param calories the calories of the item
     * @param price the price of the item
     */
    BaseItem(String name, float calories, float price)
    {
        super(name, calories,price);
    }

}
