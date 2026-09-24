import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Food class.
 */
public class FoodTest
{
    // ~ Fields ................................................................
    private Food food;
    private ArrayList<Ingredient> ingredients;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        ingredients = new ArrayList<Ingredient>();
        food = new Food("Pizza", 12.50, ingredients);
    }


    /**
     * Tests getName.
     */
    @Test
    public void testGetName()
    {
        setUp();

        assertEquals("Pizza", food.getName());
    }


    /**
     * Tests setName.
     */
    @Test
    public void testSetName()
    {
        setUp();
        food.setName("Pasta");

        assertEquals("Pasta", food.getName());
    }


    /**
     * Tests getPrice.
     */
    @Test
    public void testGetPrice()
    {
        setUp();

        assertEquals(12.50, food.getPrice(), 0.001);
    }


    /**
     * Tests setPrice.
     */
    @Test
    public void testSetPrice()
    {
        setUp();
        food.setPrice(10.00);

        assertEquals(10.00, food.getPrice(), 0.001);
    }


    /**
     * Tests getIngredients.
     */
    @Test
    public void testGetIngredients()
    {
        setUp();

        assertEquals(ingredients, food.getIngredients());
    }


    /**
     * Tests setIngredients.
     */
    @Test
    public void testSetIngredients()
    {
        setUp();
        ArrayList<Ingredient> newIngredients =
            new ArrayList<Ingredient>();
        newIngredients.add(new Ingredient("Cheese"));

        food.setIngredients(newIngredients);

        assertEquals(newIngredients, food.getIngredients());
    }


    /**
     * Tests toString.
     */
    @Test
    public void testToString()
    {
        setUp();

        assertEquals("Pizza", food.toString());
    }


    /**
     * Tests containsAllergen when an ingredient contains
     * the specified allergen.
     */
    @Test
    public void testContainsAllergen()
    {
        setUp();
        ingredients.add(new Ingredient("Cheese"));

        assertEquals(true, food.containsAllergen("Dairy"));
    }


    /**
     * Tests containsAllergen when none of the ingredients
     * contain the specified allergen.
     */
    @Test
    public void testDoesNotContainAllergen()
    {
        setUp();
        ingredients.add(new Ingredient("Cheese"));

        assertEquals(false, food.containsAllergen("Gluten"));
    }


    /**
     * Tests containsAllergen with multiple ingredients.
     */
    @Test
    public void testContainsAllergenMultipleIngredients()
    {
        setUp();
        ingredients.add(new Ingredient("Lettuce"));
        ingredients.add(new Ingredient("Bun"));
        ingredients.add(new Ingredient("Cheese"));

        assertEquals(true, food.containsAllergen("Gluten"));
        assertEquals(true, food.containsAllergen("Dairy"));
        assertEquals(false, food.containsAllergen("Peanuts"));
    }


    /**
     * Tests containsAllergen when the food has no ingredients.
     */
    @Test
    public void testContainsAllergenEmptyIngredients()
    {
        setUp();

        assertEquals(false, food.containsAllergen("Dairy"));
    }


    /**
     * Tests containsAllergen with a null allergen.
     */
    @Test
    public void testContainsNullAllergen()
    {
        setUp();
        ingredients.add(new Ingredient("Cheese"));

        assertEquals(false, food.containsAllergen(null));
    }
}