import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Food class.
 */
public class FoodTest extends student.TestCase
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
    public void testGetName()
    {
        assertEquals("Pizza", food.getName());
    }


    /**
     * Tests setName.
     */
    public void testSetName()
    {
        food.setName("Pasta");
        assertEquals("Pasta", food.getName());
    }


    /**
     * Tests getPrice.
     */
    public void testGetPrice()
    {
        assertEquals(12.50, food.getPrice(), 0.001);
    }


    /**
     * Tests setPrice.
     */
    public void testSetPrice()
    {
        food.setPrice(10.00);
        assertEquals(10.00, food.getPrice(), 0.001);
    }


    /**
     * Tests getIngredients.
     */
    public void testGetIngredients()
    {
        assertEquals(ingredients, food.getIngredients());
    }


    /**
     * Tests setIngredients.
     */
    public void testSetIngredients()
    {
        ArrayList<Ingredient> newIngredients =
            new ArrayList<Ingredient>();
        newIngredients.add(new Ingredient("Cheese"));
        food.setIngredients(newIngredients);
        assertEquals(newIngredients, food.getIngredients());
    }


    /**
     * Tests toString.
     */
    public void testToString()
    {
        assertEquals("Pizza", food.toString());
    }


    /**
     * Tests containsAllergen when an ingredient contains
     * the specified allergen.
     */
    public void testContainsAllergen()
    {
        ingredients.add(new Ingredient("Cheese"));
        assertEquals(true, food.containsAllergen("Dairy"));
    }


    /**
     * Tests containsAllergen when none of the ingredients
     * contain the specified allergen.
     */
    public void testDoesNotContainAllergen()
    {
        ingredients.add(new Ingredient("Cheese"));
        assertEquals(false, food.containsAllergen("Gluten"));
    }


    /**
     * Tests containsAllergen with multiple ingredients.
     */
    public void testContainsAllergenMultipleIngredients()
    {
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
    public void testContainsAllergenEmptyIngredients()
    {
        assertEquals(false, food.containsAllergen("Dairy"));
    }


    /**
     * Tests containsAllergen with a null allergen.
     */
    public void testContainsNullAllergen()
    {
        ingredients.add(new Ingredient("Cheese"));
        assertEquals(false, food.containsAllergen(null));
    }
}