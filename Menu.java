import java.util.ArrayList;

public class Menu {
    private ArrayList<Food> foods;

    public Menu() {
        this.foods = new ArrayList<>();
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