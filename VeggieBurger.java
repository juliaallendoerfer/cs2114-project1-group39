public class VeggieBurger extends Burger {
    /**
     * Creates a veggie burger with the specified details.
     *
     * @param name: the name of the veggie burger
     * @param price: the price of the veggie burger
     * @param ingredients: the ingredients contained in the veggie burger
     */
    public VeggieBurger(String name, double price, ArrayList<Ingredient> ingredients) {
        super(name, price, ingredients);
    }
}