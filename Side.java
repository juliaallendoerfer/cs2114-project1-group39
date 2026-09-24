/**
 * Represents a side item of type Food.
 */
public class Side extends Food {
    /**
     * Creates a side with the specified details.
     *
     * @param name the name of the side
     * @param price the price of the side
     * @param ingredients the ingredients contained in the side
     */
    public Side(String name, double price, ArrayList<Ingredient> ingredients) {
        super(name, price, ingredients);
    }

    /**
     * Returns the side's name and price as a string.
     *
     * @return the side's formatted name and price
     */
    @Override
    public String toString() {
        return "Side: " + getName() + ", Price: $" + getPrice();
    }
}