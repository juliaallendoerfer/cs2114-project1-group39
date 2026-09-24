import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Side class.
 */
public class SideTest
{
    // ~ Fields ................................................................
    private Side side;
    private ArrayList<Ingredient> ingredients;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Potatoes"));
        ingredients.add(new Ingredient("Vegetable Oil"));
        ingredients.add(new Ingredient("Salt"));

        side = new Side("Fries", 3.00, ingredients);
    }


    /**
     * Tests that the side stores its name.
     */
    @Test
    public void testGetName()
    {
        setUp();

        assertEquals("Fries", side.getName());
    }


    /**
     * Tests that the side stores its price.
     */
    @Test
    public void testGetPrice()
    {
        setUp();

        assertEquals(3.00, side.getPrice(), 0.001);
    }


    /**
     * Tests that the side stores its ingredients.
     */
    @Test
    public void testGetIngredients()
    {
        setUp();

        assertEquals(ingredients, side.getIngredients());
        assertEquals(3, side.getIngredients().size());
    }


    /**
     * Tests that a side is a Food object.
     */
    @Test
    public void testSideIsFood()
    {
        setUp();

        assertEquals(true, side instanceof Food);
    }


    /**
     * Tests the side string representation.
     */
    @Test
    public void testToString()
    {
        setUp();

        assertEquals(
            "Side: Fries, Price: $3.0",
            side.toString());
    }


    /**
     * Tests a side with an empty ingredient list.
     */
    @Test
    public void testEmptyIngredients()
    {
        setUp();

        Side emptySide = new Side(
            "Empty Side",
            1.00,
            new ArrayList<Ingredient>());

        assertEquals(0, emptySide.getIngredients().size());
        assertEquals(
            "Side: Empty Side, Price: $1.0",
            emptySide.toString());
    }


    /**
     * Tests allergen checking inherited from Food.
     */
    @Test
    public void testDoesNotContainAllergen()
    {
        setUp();

        assertEquals(false, side.containsAllergen("Gluten"));
    }


    /**
     * Tests allergen checking with an allergen-containing side.
     */
    @Test
    public void testContainsAllergen()
    {
        setUp();

        ingredients.add(new Ingredient("Wheat Flour"));

        assertEquals(true, side.containsAllergen("Gluten"));
    }
}