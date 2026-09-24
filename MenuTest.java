import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class MenuTest extends student.TestCase {

    private Menu menu;
    private Customer customer;
    private Food veggieBurger;
    private Food cheeseBurger;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        
        customer = new Customer("John Doe"); 
        
        customer.addAllergen("Dairy");

        veggieBurger = new Food("Veggie Burger", 8.99); 
        cheeseBurger = new Food("Cheese Burger", 9.99);
        
        Ingredient bun = new Ingredient("Bun");
        bun.addAllergen("Gluten");
        
        Ingredient cheese = new Ingredient("Cheese");
        cheese.addAllergen("Dairy");
        
        veggieBurger.addIngredient(bun);
        cheeseBurger.addIngredient(bun);
        cheeseBurger.addIngredient(cheese);
    }

    @Test
    public void testAddAndGetFoods() {
        menu.addFood(veggieBurger);
        menu.addFood(cheeseBurger);
        
        ArrayList<Food> foods = menu.getFoods();
        
        assertEquals(2, foods.size(), "Menu should contain 2 foods.");
        assertTrue(foods.contains(veggieBurger), "Menu should contain Veggie Burger.");
        assertTrue(foods.contains(cheeseBurger), "Menu should contain Cheese Burger.");
    }

    @Test
    public void testFilterMenu() {
        menu.addFood(veggieBurger);
        menu.addFood(cheeseBurger);

        ArrayList<Food> filteredMenu = menu.filterMenu(customer);
        
        assertEquals(1, filteredMenu.size(), "Filtered menu should only contain 1 safe food.");
        assertTrue(filteredMenu.contains(veggieBurger), "Filtered menu should contain the safe Veggie Burger.");
        assertFalse(filteredMenu.contains(cheeseBurger), "Filtered menu should NOT contain the unsafe Cheese Burger.");
    }
    
    @Test
    public void testFilterMenuMultipleAllergens() {
        menu.addFood(veggieBurger);
        menu.addFood(cheeseBurger);
        
        customer.addAllergen("Gluten");
        
        ArrayList<Food> filteredMenu = menu.filterMenu(customer);
        
        assertEquals(0, filteredMenu.size(), "Filtered menu should be empty since all foods contain an allergen.");
    }
}
