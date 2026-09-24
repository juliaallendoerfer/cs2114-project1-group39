import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Burger class.
 */
public class BurgerTest extends student.TestCase
{
    // ~ Fields ................................................................
    private Burger burger;
    private ArrayList<Ingredient> ingredients;

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Beef Patty"));
        ingredients.add(new Ingredient("Cheese"));
        ingredients.add(new Ingredient("Lettuce"));

        burger = new Burger("Cheeseburger", 8.50, ingredients);
    }


    /**
     * Tests that the burger stores its name.
     */
    public void testGetName()
    {
        assertEquals("Cheeseburger", burger.getName());
    }


    /**
     * Tests that the burger stores its price.
     */
    public void testGetPrice()
    {
        assertEquals(8.50, burger.getPrice(), 0.001);
    }


    /**
     * Tests that the burger stores its ingredients.
     */
    public void testGetIngredients()
    {
        assertEquals(ingredients, burger.getIngredients());
        assertEquals(3, burger.getIngredients().size());
    }


    /**
     * Tests that a burger is a Food object.
     */
    public void testBurgerIsFood()
    {
        assertEquals(true, burger instanceof Food);
    }


    /**
     * Tests the burger string representation.
     */
    public void testToString()
    {
        assertEquals(
            "Burger: Cheeseburger, Price: $8.5",
            burger.toString());
    }


    /**
     * Tests a burger with an empty ingredient list.
     */
    public void testEmptyIngredients()
    {
        Burger plain = new Burger(
            "Plain Burger",
            6.00,
            new ArrayList<Ingredient>());

        assertEquals(0, plain.getIngredients().size());
        assertEquals(
            "Burger: Plain Burger, Price: $6.0",
            plain.toString());
    }


    /**
     * Tests allergen checking inherited from Food.
     */
    public void testContainsAllergen()
    {
        assertEquals(true, burger.containsAllergen("Dairy"));
        assertEquals(false, burger.containsAllergen("Gluten"));
    }
}