import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Ingredient class.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class IngredientTest
{
    // ~ Fields ................................................................
    private Ingredient ingredient;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

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
    @Test
    public void testGetName()
    {
        setUp();

        assertEquals("Cheese", ingredient.getName());
    }


    /**
     * Tests dairy allergen detection.
     */
    @Test
    public void testContainsDairy()
    {
        setUp();

        assertEquals(true, ingredient.containsAllergen("Dairy"));
    }


    /**
     * Tests gluten allergen detection.
     */
    @Test
    public void testContainsGluten()
    {
        Ingredient bun = new Ingredient("Bun");

        assertEquals(true, bun.containsAllergen("Gluten"));
    }


    /**
     * Tests peanut allergen detection.
     */
    @Test
    public void testContainsPeanuts()
    {
        Ingredient peanuts = new Ingredient("Peanuts");

        assertEquals(true, peanuts.containsAllergen("Peanuts"));
    }


    /**
     * Tests tree nut allergen detection.
     */
    @Test
    public void testContainsTreeNuts()
    {
        Ingredient almonds = new Ingredient("Almonds");

        assertEquals(true, almonds.containsAllergen("Tree Nuts"));
    }


    /**
     * Tests egg allergen detection.
     */
    @Test
    public void testContainsEggs()
    {
        Ingredient egg = new Ingredient("Egg");

        assertEquals(true, egg.containsAllergen("Eggs"));
    }


    /**
     * Tests soy allergen detection.
     */
    @Test
    public void testContainsSoy()
    {
        Ingredient tofu = new Ingredient("Tofu");

        assertEquals(true, tofu.containsAllergen("Soy"));
    }


    /**
     * Tests when the ingredient does not contain an allergen.
     */
    @Test
    public void testDoesNotContainAllergen()
    {
        setUp();

        assertEquals(false, ingredient.containsAllergen("Gluten"));
    }


    /**
     * Tests an unsupported allergen.
     */
    @Test
    public void testUnsupportedAllergen()
    {
        setUp();

        assertEquals(false, ingredient.containsAllergen("Shellfish"));
    }


    /**
     * Tests case-insensitive ingredient matching.
     */
    @Test
    public void testIngredientCaseInsensitive()
    {
        Ingredient cheese = new Ingredient("CHEESE");

        assertEquals(true, cheese.containsAllergen("Dairy"));
    }


    /**
     * Tests case-insensitive allergen matching.
     */
    @Test
    public void testAllergenCaseInsensitive()
    {
        setUp();

        assertEquals(true, ingredient.containsAllergen("dairy"));
    }


    /**
     * Tests a null allergen.
     */
    @Test
    public void testNullAllergen()
    {
        setUp();

        assertEquals(false, ingredient.containsAllergen(null));
    }
}