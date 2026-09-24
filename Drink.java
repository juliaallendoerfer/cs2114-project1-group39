/**
 * Represents a drink item of type Food.
 */
public class Drink extends Food {
    /**
     * Creates a drink with the specified details.
     *
     * @param name the name of the drink
     * @param price the price of the drink
     * @param ingredients the ingredients contained in the drink
     */
    public Drink(String name, double price, ArrayList<Ingredient> ingredients) {
        super(name, price, ingredients);
    }

    /**
     * Returns the drink's name and price as a string.
     *
     * @return the drink's formatted name and price
     */
    @Override
    public String toString() {
        return "Drink: " + getName() + ", Price: $" + getPrice();
    }
}