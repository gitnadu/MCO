
/**
 * This class represents the cash object. It has a value, its count and its total value
 * based on its value and count.
 * 
 * @author Adriel Manuel D. Fancubit
 */
public class Cash {

    private int value;
    private int count;
    private int totalValue;

    /**
     *
     * Constructs a cash object, with its value
     *
     * @param value value of the cash
     */
    Cash(int value)
    {
        this.value = value;
        this.count = 0;
        this.totalValue = 0;
    }

    /**
     *
     * Gets the count
     *
     * @return the count
     */
    public int getCount() {

        return count;
    }

    /**
     *
     * Gets the value
     *
     * @return the value
     */
    public int getValue() {

        return value;
    }

    /**
     *
     * Gets the total value
     *
     * @return the total value
     */
    public int getTotalValue() {

        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    /**
     *
     * Sets the value
     *
     * @param value  the value.
     */
    public void setValue(int value) {

        this.value = value;
    }

    /**
     *
     * Sets the count
     *
     * @param count  the count.
     */
    public void setCount(int count) {

        this.count = count;
    }
}
