import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Tests the Menu class.
 */
public class MenuTest
{
    // ~ Fields ................................................................
    private Menu menu;
    private Customer customer;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        menu = new Menu();
        customer = new Customer("Test User");
    }


    /**
     * Tests that a new menu contains all food items.
     */
    @Test
    public void testGetFoods()
    {
        setUp();

        assertEquals(10, menu.getFoods().size());
        assertEquals("Veggie Burger", menu.getFoods().get(0).getName());
        assertEquals("Milkshake", menu.getFoods().get(9).getName());
    }


    /**
     * Tests adding a food to the menu.
     */
    @Test
    public void testAddFood()
    {
        setUp();

        Food food = new Food(
            "Test Food",
            5.00,
            new ArrayList<Ingredient>());

        menu.addFood(food);

        assertEquals(11, menu.getFoods().size());
        assertEquals(true, menu.getFoods().contains(food));
    }


    /**
     * Tests filtering when the customer has no allergens.
     */
    @Test
    public void testFilterMenuNoAllergens()
    {
        setUp();

        ArrayList<Food> filteredMenu =
            menu.filterMenu(customer);

        assertEquals(10, filteredMenu.size());
    }


    /**
     * Tests filtering the menu for a dairy allergy.
     */
    @Test
    public void testFilterMenuDairy()
    {
        setUp();
        customer.addAllergen("Dairy");

        ArrayList<Food> filteredMenu =
            menu.filterMenu(customer);

        assertEquals(7, filteredMenu.size());
        assertEquals(
            false,
            containsFood(filteredMenu, "Cheese Burger"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Caesar Salad"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Milkshake"));
    }


    /**
     * Tests filtering the menu for a gluten allergy.
     */
    @Test
    public void testFilterMenuGluten()
    {
        setUp();
        customer.addAllergen("Gluten");

        ArrayList<Food> filteredMenu =
            menu.filterMenu(customer);

        assertEquals(
            false,
            containsFood(filteredMenu, "Veggie Burger"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Chicken Burger"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Cheese Burger"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Onion Rings"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Caesar Salad"));

        assertEquals(
            true,
            containsFood(
                filteredMenu,
                "Gluten-Free Bun Burger"));
    }


    /**
     * Tests filtering the menu with multiple allergens.
     */
    @Test
    public void testFilterMenuMultipleAllergens()
    {
        setUp();
        customer.addAllergen("Dairy");
        customer.addAllergen("Gluten");

        ArrayList<Food> filteredMenu =
            menu.filterMenu(customer);

        assertEquals(
            false,
            containsFood(filteredMenu, "Cheese Burger"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Milkshake"));
        assertEquals(
            false,
            containsFood(filteredMenu, "Onion Rings"));

        assertEquals(
            true,
            containsFood(
                filteredMenu,
                "Gluten-Free Bun Burger"));
        assertEquals(
            true,
            containsFood(filteredMenu, "Fries"));
        assertEquals(
            true,
            containsFood(filteredMenu, "Water"));
    }


    /**
     * Checks whether a list contains a food with the specified name.
     *
     * @param foods the foods to search
     * @param name the food name to find
     * @return true if the food is present; false otherwise
     */
    private boolean containsFood(ArrayList<Food> foods, String name)
    {
        for (Food food : foods)
        {
            if (food.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }
}