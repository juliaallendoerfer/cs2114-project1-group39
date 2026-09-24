import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Drink} class.
 *
 * <p>Verifies that a Drink is constructed correctly, inherits from
 * {@link Food}, and produces the expected string representation.</p>
 */
public class DrinkTest {

    /** The list of ingredients used to build the test drink. */
    private ArrayList<Ingredient> ingredients;

    /** The drink instance under test. */
    private Drink drink;

    /**
     * Creates a fresh drink and ingredient list before each test.
     */
    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Water"));
        ingredients.add(new Ingredient("Lemon"));

        drink = new Drink("Lemonade", 3.50, ingredients);
    }

    /**
     * Verifies that the constructor stores the drink's name.
     */
    @Test
    void constructor_setsName() {
        assertEquals("Lemonade", drink.getName());
    }

    /**
     * Verifies that the constructor stores the drink's price.
     */
    @Test
    void constructor_setsPrice() {
        assertEquals(3.50, drink.getPrice(), 0.0001);
    }

    /**
     * Verifies that the constructor stores the drink's ingredients.
     */
    @Test
    void constructor_setsIngredients() {
        assertEquals(ingredients, drink.getIngredients());
        assertEquals(2, drink.getIngredients().size());
    }

    /**
     * Verifies that a drink can be created with an empty ingredient list.
     */
    @Test
    void constructor_allowsEmptyIngredientList() {
        Drink water = new Drink("Water", 0.0, new ArrayList<>());
        assertEquals("Water", water.getName());
        assertEquals(0.0, water.getPrice(), 0.0001);
    }

    /**
     * Verifies that a Drink is a subtype of {@link Food}.
     */
    @Test
    void isInstanceOfFood() {
        assertTrue(drink instanceof Food);
    }

    /**
     * Verifies that {@code toString()} returns the name and price
     * in the expected format.
     */
    @Test
    void toString_returnsFormattedNameAndPrice() {
        assertEquals("Drink: Lemonade, Price: $3.5", drink.toString());
    }

    /**
     * Verifies {@code toString()} output for a whole-number price.
     */
    @Test
    void toString_wholeNumberPrice() {
        Drink soda = new Drink("Soda", 2.0, new ArrayList<>());
        assertEquals("Drink: Soda, Price: $2.0", soda.toString());
    }

    /**
     * Verifies {@code toString()} output for a price of zero.
     */
    @Test
    void toString_zeroPrice() {
        Drink water = new Drink("Water", 0.0, new ArrayList<>());
        assertEquals("Drink: Water, Price: $0.0", water.toString());
    }

    /**
     * Verifies that {@code toString()} begins with the "Drink: " prefix.
     */
    @Test
    void toString_startsWithDrinkPrefix() {
        assertTrue(drink.toString().startsWith("Drink: "));
    }
}
