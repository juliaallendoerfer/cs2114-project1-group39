import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Burger} class.
 *
 * <p>Verifies that a Burger is constructed correctly, inherits from
 * {@link Food}, and produces the expected string representation.</p>
 */
public class BurgerTest {

    /** The list of ingredients used to build the test burger. */
    private ArrayList<Ingredient> ingredients;

    /** The burger instance under test. */
    private Burger burger;

    /**
     * Creates a fresh burger and ingredient list before each test.
     *
     * <p>ASSUMPTION: {@code Ingredient} has a constructor that takes a name.
     * Adjust this to match your Ingredient class.</p>
     */
    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Beef Patty"));
        ingredients.add(new Ingredient("Cheese"));
        ingredients.add(new Ingredient("Lettuce"));

        burger = new Burger("Cheeseburger", 8.50, ingredients);
    }

    /**
     * Verifies that the constructor stores the burger's name.
     */
    @Test
    void constructor_setsName() {
        assertEquals("Cheeseburger", burger.getName());
    }

    /**
     * Verifies that the constructor stores the burger's price.
     */
    @Test
    void constructor_setsPrice() {
        assertEquals(8.50, burger.getPrice(), 0.0001);
    }

    /**
     * Verifies that the constructor stores the burger's ingredients.
     *
     * <p>ASSUMPTION: {@code Food} exposes {@code getIngredients()}.
     * Remove this test if it does not.</p>
     */
    @Test
    void constructor_setsIngredients() {
        assertEquals(ingredients, burger.getIngredients());
        assertEquals(3, burger.getIngredients().size());
    }

    /**
     * Verifies that a burger can be created with an empty ingredient list.
     */
    @Test
    void constructor_allowsEmptyIngredientList() {
        Burger plain = new Burger("Plain Bun", 1.0, new ArrayList<>());
        assertEquals("Plain Bun", plain.getName());
        assertEquals(1.0, plain.getPrice(), 0.0001);
    }

    /**
     * Verifies that a Burger is a subtype of {@link Food}.
     */
    @Test
    void isInstanceOfFood() {
        assertTrue(burger instanceof Food);
    }

    /**
     * Verifies that {@code toString()} returns the name and price
     * in the expected format.
     */
    @Test
    void toString_returnsFormattedNameAndPrice() {
        assertEquals("Burger: Cheeseburger, Price: $8.5", burger.toString());
    }

    /**
     * Verifies {@code toString()} output for a whole-number price.
     */
    @Test
    void toString_wholeNumberPrice() {
        Burger basic = new Burger("Hamburger", 6.0, new ArrayList<>());
        assertEquals("Burger: Hamburger, Price: $6.0", basic.toString());
    }

    /**
     * Verifies {@code toString()} output for a price of zero.
     */
    @Test
    void toString_zeroPrice() {
        Burger free = new Burger("Free Sample", 0.0, new ArrayList<>());
        assertEquals("Burger: Free Sample, Price: $0.0", free.toString());
    }

    /**
     * Verifies that {@code toString()} begins with the "Burger: " prefix.
     */
    @Test
    void toString_startsWithBurgerPrefix() {
        assertTrue(burger.toString().startsWith("Burger: "));
    }
}
