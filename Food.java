import java.util.ArrayList;

/**
 * Represents a food item with a name, price, and list of ingredients.
 */
public class Food{
    /** The name of the food item. */
    private String name;
    /** The price of the food item. */
    private double price;
    /** The ingredients contained in the food item. */
    private ArrayList<Ingredient> ingredients;

    /**
     * Creates a food item with the specified details.
     *
     * @param name: the name of the food item
     * @param price: the price of the food item
     * @param ingredients: the ingredients contained in the food item
     */
    public Food(String name, double price, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    /**
     * Returns the food item's name.
     *
     * @return the food item's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Changes the food item's name.
     *
     * @param name the new food item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the food item's price.
     *
     * @return the food item's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Changes the food item's price.
     *
     * @param price the new food item price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the food item's ingredients.
     *
     * @return the food item's ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Changes the food item's ingredients.
     *
     * @param ingredients the new list of ingredients
     */
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns the food item's name as its string representation.
     *
     * @return the food item's name
     */
    public String toString() {
        return name;
    }

    /**
     * Checks whether any ingredient in this food contains
     * the specified allergen.
     *
     * @param allergen the allergen to check
     * @return true if an ingredient contains the allergen;
     *         false otherwise
     */
    public boolean containsAllergen(String allergen)
    {
        for (Ingredient ingredient : ingredients)
        {
            if (ingredient.containsAllergen(allergen))
            {
                return true;
            }
        }

        return false;
    }
}
