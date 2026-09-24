import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Ingredient class.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class IngredientTest extends student.TestCase
{
    // ~ Fields ................................................................
    private Ingredient ingredient;

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        ingredient = new Ingredient("Cheese");
    }


    /**
     * Tests getName.
     */

    public void testGetName()
    {
        assertEquals("Cheese", ingredient.getName());
    }


    /**
     * Tests dairy allergen detection.
     */
    public void testContainsDairy()
    {
        assertEquals(true, ingredient.containsAllergen("Dairy"));
    }


    /**
     * Tests gluten allergen detection.
     */
    public void testContainsGluten()
    {
        Ingredient bun = new Ingredient("Bun");
        assertEquals(true, bun.containsAllergen("Gluten"));
    }


    /**
     * Tests peanut allergen detection.
     */
    public void testContainsPeanuts()
    {
        Ingredient peanuts = new Ingredient("Peanuts");
        assertEquals(true, peanuts.containsAllergen("Peanuts"));
    }


    /**
     * Tests tree nut allergen detection.
     */
    public void testContainsTreeNuts()
    {
        Ingredient almonds = new Ingredient("Almonds");
        assertEquals(true, almonds.containsAllergen("Tree Nuts"));
    }


    /**
     * Tests egg allergen detection.
     */
    public void testContainsEggs()
    {
        Ingredient egg = new Ingredient("Egg");
        assertEquals(true, egg.containsAllergen("Eggs"));
    }


    /**
     * Tests soy allergen detection.
     */
    public void testContainsSoy()
    {
        Ingredient tofu = new Ingredient("Tofu");
        assertEquals(true, tofu.containsAllergen("Soy"));
    }


    /**
     * Tests when the ingredient does not contain an allergen.
     */
    public void testDoesNotContainAllergen()
    {
        assertEquals(false, ingredient.containsAllergen("Gluten"));
    }


    /**
     * Tests an unsupported allergen.
     */
    public void testUnsupportedAllergen()
    {
        assertEquals(false, ingredient.containsAllergen("Shellfish"));
    }


    /**
     * Tests case-insensitive ingredient matching.
     */
    public void testIngredientCaseInsensitive()
    {
        Ingredient cheese = new Ingredient("CHEESE");
        assertEquals(true, cheese.containsAllergen("Dairy"));
    }


    /**
     * Tests case-insensitive allergen matching.
     */
    public void testAllergenCaseInsensitive()
    {
        assertEquals(true, ingredient.containsAllergen("dairy"));
    }


    /**
     * Tests a null allergen.
     */
    public void testNullAllergen()
    {
        assertEquals(false, ingredient.containsAllergen(null));
    }
}