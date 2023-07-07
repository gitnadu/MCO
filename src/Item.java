
/**


 * This class implements an item object. It includes a name, its calories,
 * and its price
 * 
 * @author Adriel Manuel D. Fancubit
 *
 */


public class Item {
    private float calories;
    private float price;
    private String name;

    /**
     *
     * Constructs an item object, with its given name, its price and its calories
     * @param name the name of the item
     * @param calories the calories of the item
     * @param price the price of the item
     */
    Item(String name,float price,float calories)
    {
        this.calories = calories;
        this.price = price;
        this.name = name;
    }
    /**
     *
     * Constructs an item object, with an item object
     *
     * @param item an item object
     */
    Item(Item item)
    {
        this.calories = item.getCalories();
        this.price = item.getPrice();
        this.name = item.getName();
    }


    /**
     *
     * Gets the calories of the item
     *
     * @return the calories of the item
     */
    public float getCalories() {

        return calories;
    }


    /**
     *
     * Gets the price of the item
     *
     * @return the price of the item
     */
    public float getPrice() {

        return price;
    }


    /**
     *
     * Gets the name of the item
     *
     * @return the name of the item
     */
    public String getName() {

        return name;
    }


    /**
     *
     * Sets the price of the item
     *
     *
     * @param price  a price
     */
    public void setPrice(float price) {

        this.price = price;
    }

}
