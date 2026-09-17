import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests the behavior of the Food class.
 */
public class FoodTest {
	/** Tests that the constructor stores each supplied value. */
	@Test
	public void testConstructorAndGetters() {
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		Food food = new Food("Pizza", 12.50, ingredients);

		assertEquals("Pizza", food.getName());
		assertEquals(12.50, food.getPrice(), 0.001);
		assertSame(ingredients, food.getIngredients());
	}

	/** Tests that setName updates the food name. */
	@Test
	public void testSetName() {
		Food food = new Food("Pizza", 12.50,
			new ArrayList<Ingredient>());

		food.setName("Pasta");

		assertEquals("Pasta", food.getName());
	}

	/** Tests that setPrice updates the food price. */
	@Test
	public void testSetPrice() {
		Food food = new Food("Pizza", 12.50,
			new ArrayList<Ingredient>());

		food.setPrice(10.00);

		assertEquals(10.00, food.getPrice(), 0.001);
	}

	/** Tests that setIngredients updates the ingredient list. */
	@Test
	public void testSetIngredients() {
		Food food = new Food("Pizza", 12.50,
			new ArrayList<Ingredient>());
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

		food.setIngredients(ingredients);

		assertSame(ingredients, food.getIngredients());
	}

	/** Tests that toString returns the food name. */
	@Test
	public void testToString() {
		Food food = new Food("Pizza", 12.50,
			new ArrayList<Ingredient>());

		assertEquals("Pizza", food.toString());
	}
}
