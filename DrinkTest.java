import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Drink class.
 */
public class DrinkTest
{
    // ~ Fields ................................................................
    private Drink drink;
    private ArrayList<Ingredient> ingredients;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

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
    @Test
    public void testGetName()
    {
        setUp();

        assertEquals("Soda", drink.getName());
    }


    /**
     * Tests that the drink stores its price.
     */
    @Test
    public void testGetPrice()
    {
        setUp();

        assertEquals(2.00, drink.getPrice(), 0.001);
    }


    /**
     * Tests that the drink stores its ingredients.
     */
    @Test
    public void testGetIngredients()
    {
        setUp();

        assertEquals(ingredients, drink.getIngredients());
        assertEquals(2, drink.getIngredients().size());
    }


    /**
     * Tests that a drink is a Food object.
     */
    @Test
    public void testDrinkIsFood()
    {
        setUp();

        assertEquals(true, drink instanceof Food);
    }


    /**
     * Tests the drink string representation.
     */
    @Test
    public void testToString()
    {
        setUp();

        assertEquals(
            "Drink: Soda, Price: $2.0",
            drink.toString());
    }


    /**
     * Tests a drink with an empty ingredient list.
     */
    @Test
    public void testEmptyIngredients()
    {
        setUp();
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
    @Test
    public void testContainsAllergen()
    {
        setUp();

        assertEquals(false, drink.containsAllergen("Dairy"));
    }


    /**
     * Tests allergen checking with an allergen-containing drink.
     */
    @Test
    public void testContainsAllergenDairy()
    {
        setUp();
        ingredients.add(new Ingredient("Milk"));

        assertEquals(true, drink.containsAllergen("Dairy"));
    }
}