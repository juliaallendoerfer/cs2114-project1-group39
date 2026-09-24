import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Burger class.
 */
public class BurgerTest
{
    // ~ Fields ................................................................
    private Burger burger;
    private ArrayList<Ingredient> ingredients;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

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
    @Test
    public void testGetName()
    {
        setUp();

        assertEquals("Cheeseburger", burger.getName());
    }


    /**
     * Tests that the burger stores its price.
     */
    @Test
    public void testGetPrice()
    {
        setUp();

        assertEquals(8.50, burger.getPrice(), 0.001);
    }


    /**
     * Tests that the burger stores its ingredients.
     */
    @Test
    public void testGetIngredients()
    {
        setUp();

        assertEquals(ingredients, burger.getIngredients());
        assertEquals(3, burger.getIngredients().size());
    }


    /**
     * Tests that a burger is a Food object.
     */
    @Test
    public void testBurgerIsFood()
    {
        setUp();

        assertEquals(true, burger instanceof Food);
    }


    /**
     * Tests the burger string representation.
     */
    @Test
    public void testToString()
    {
        setUp();

        assertEquals(
            "Burger: Cheeseburger, Price: $8.5",
            burger.toString());
    }


    /**
     * Tests a burger with an empty ingredient list.
     */
    @Test
    public void testEmptyIngredients()
    {
        setUp();
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
    @Test
    public void testContainsAllergen()
    {
        setUp();

        assertEquals(true, burger.containsAllergen("Dairy"));
        assertEquals(false, burger.containsAllergen("Gluten"));
    }
}