import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<Food> foods;

    public Menu() {
        this.foods = new ArrayList<>();
        ArrayList<Ingredient> veggieBurgerIngredients =
        new ArrayList<>(Arrays.asList(
            new Ingredient("Bun"),
            new Ingredient("Veggie Patty"),
            new Ingredient("Lettuce"),
            new Ingredient("Tomato"),
            new Ingredient("Onion"),
            new Ingredient("Mayonnaise")
        ));
        
        Burger veggieBurger = new Burger("Veggie Burger", 7.50, veggieBurgerIngredients);

        foods.add(veggieBurger);

        ArrayList<Ingredient> chickenBurgerIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Bun"),
                new Ingredient("Chicken Patty"),
                new Ingredient("Lettuce"),
                new Ingredient("Tomato"),
                new Ingredient("Mayonnaise")
            ));

        Burger chickenBurger =
            new Burger("Chicken Burger", 8.50, chickenBurgerIngredients);

        foods.add(chickenBurger);

        ArrayList<Ingredient> cheeseBurgerIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Bun"),
                new Ingredient("Beef Patty"),
                new Ingredient("Cheese"),
                new Ingredient("Lettuce"),
                new Ingredient("Tomato"),
                new Ingredient("Onion")
            ));

        Burger cheeseBurger =
            new Burger("Cheese Burger", 9.00, cheeseBurgerIngredients);

        foods.add(cheeseBurger);

        ArrayList<Ingredient> glutenFreeBurgerIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Gluten-Free Bun"),
                new Ingredient("Beef Patty"),
                new Ingredient("Lettuce"),
                new Ingredient("Tomato"),
                new Ingredient("Onion")
            ));

        Burger glutenFreeBurger =
            new Burger("Gluten-Free Bun Burger", 9.50, glutenFreeBurgerIngredients);

        foods.add(glutenFreeBurger);

        ArrayList<Ingredient> friesIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Potatoes"),
                new Ingredient("Vegetable Oil"),
                new Ingredient("Salt")
            ));

        Side fries =
            new Side("Fries", 3.00, friesIngredients);

        foods.add(fries);

        ArrayList<Ingredient> onionRingsIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Onion"),
                new Ingredient("Wheat Flour"),
                new Ingredient("Egg"),
                new Ingredient("Vegetable Oil"),
                new Ingredient("Salt")
            ));

        Side onionRings =
            new Side("Onion Rings", 3.50, onionRingsIngredients);

        foods.add(onionRings);

        ArrayList<Ingredient> caesarSaladIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Lettuce"),
                new Ingredient("Parmesan Cheese"),
                new Ingredient("Croutons"),
                new Ingredient("Caesar Dressing")
            ));

        Side caesarSalad =
            new Side("Caesar Salad", 4.50, caesarSaladIngredients);

        foods.add(caesarSalad);

        ArrayList<Ingredient> sodaIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Carbonated Water"),
                new Ingredient("Sugar")
            ));

        Drink soda =
            new Drink("Soda", 2.00, sodaIngredients);

        foods.add(soda);

        ArrayList<Ingredient> waterIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Water")
            ));

        Drink water =
            new Drink("Water", 1.50, waterIngredients);

        foods.add(water);

        ArrayList<Ingredient> milkshakeIngredients =
            new ArrayList<>(Arrays.asList(
                new Ingredient("Milk"),
                new Ingredient("Ice Cream"),
                new Ingredient("Sugar")
            ));

        Drink milkshake =
            new Drink("Milkshake", 4.00, milkshakeIngredients);

        foods.add(milkshake);
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public ArrayList<Food> filterMenu(Customer customer) {
        ArrayList<Food> compatibleFoods = new ArrayList<>();

        for (Food food : this.foods) {
            boolean isSafe = true;
            for (String allergen : customer.getAllergens()) {
                if (food.containsAllergen(allergen)) {
                    isSafe = false;
                    break; 
                }
            }
            if (isSafe) {
                compatibleFoods.add(food);
            }
        }
        return compatibleFoods;
    }
}
