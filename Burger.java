import java.util.ArrayList;

/**
 * Represents a burger item of type Food.
 */
public class Burger extends Food {
    /**
     * Creates a burger with the specified details.
     *
     * @param name: the name of the burger
     * @param price: the price of the burger
     * @param ingredients: the ingredients contained in the burger
     */
    public Burger(String name, double price, ArrayList<Ingredient> ingredients) {
        super(name, price, ingredients);
    }

    /**
     * Returns the burger's name and price as a string.
     *
     * @return the burger's formatted name and price
     */
    @Override
    public String toString() {
        return "Burger: " + getName() + ", Price: $" + getPrice();
    }
}