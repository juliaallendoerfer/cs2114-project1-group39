import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Side class.
 */
public class SideTest extends student.TestCase
{
    // ~ Fields ................................................................
    private Side side;
    private ArrayList<Ingredient> ingredients;

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
    public void testGetName()
    {
        assertEquals("Fries", side.getName());
    }


    /**
     * Tests that the side stores its price.
     */
    public void testGetPrice()
    {
        assertEquals(3.00, side.getPrice(), 0.001);
    }


    /**
     * Tests that the side stores its ingredients.
     */
    public void testGetIngredients()
    {
        assertEquals(ingredients, side.getIngredients());
        assertEquals(3, side.getIngredients().size());
    }


    /**
     * Tests that a side is a Food object.
     */
    public void testSideIsFood()
    {
        assertEquals(true, side instanceof Food);
    }


    /**
     * Tests the side string representation.
     */
    public void testToString()
    {
        assertEquals(
            "Side: Fries, Price: $3.0",
            side.toString());
    }


    /**
     * Tests a side with an empty ingredient list.
     */
    public void testEmptyIngredients()
    {
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
    public void testDoesNotContainAllergen()
    {
        assertEquals(false, side.containsAllergen("Gluten"));
    }


    /**
     * Tests allergen checking with an allergen-containing side.
     */
    public void testContainsAllergen()
    {
        ingredients.add(new Ingredient("Wheat Flour"));
        assertEquals(true, side.containsAllergen("Gluten"));
    }
}