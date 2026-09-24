import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Drink class.
 */
public class DrinkTest extends student.TestCase
{
    // ~ Fields ................................................................
    private Drink drink;
    private ArrayList<Ingredient> ingredients;

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Water"));
        ingredients.add(new Ingredient("Sugar"));

        drink = new Drink("Soda", 2.00, ingredients);
    }


    /**
     * Tests that the drink stores its name.
     */
    public void testGetName()
    {
        assertEquals("Soda", drink.getName());
    }


    /**
     * Tests that the drink stores its price.
     */
    public void testGetPrice()
    {
        assertEquals(2.00, drink.getPrice(), 0.001);
    }


    /**
     * Tests that the drink stores its ingredients.
     */
    public void testGetIngredients()
    {
        assertEquals(ingredients, drink.getIngredients());
        assertEquals(2, drink.getIngredients().size());
    }


    /**
     * Tests that a drink is a Food object.
     */
    public void testDrinkIsFood()
    {
        assertEquals(true, drink instanceof Food);
    }


    /**
     * Tests the drink string representation.
     */
    public void testToString()
    {
        assertEquals(
            "Drink: Soda, Price: $2.0",
            drink.toString());
    }


    /**
     * Tests a drink with an empty ingredient list.
     */
    public void testEmptyIngredients()
    {
        Drink water = new Drink(
            "Water",
            1.50,
            new ArrayList<Ingredient>());

        assertEquals(0, water.getIngredients().size());
        assertEquals(
            "Drink: Water, Price: $1.5",
            water.toString());
    }


    /**
     * Tests allergen checking inherited from Food.
     */
    public void testContainsAllergen()
    {
        assertEquals(false, drink.containsAllergen("Dairy"));
    }


    /**
     * Tests allergen checking with an allergen-containing drink.
     */
    public void testContainsAllergenDairy()
    {
        ingredients.add(new Ingredient("Milk"));
        assertEquals(true, drink.containsAllergen("Dairy"));
    }
}