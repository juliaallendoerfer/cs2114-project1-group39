import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Tests the Order class.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class OrderTest extends student.TestCase
{
    // ~ Fields ................................................................
    private Order order;
    private Food burger;
    private Food fries;

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        order = new Order();

        burger = new Food(
            "Cheese Burger",
            8.50,
            new ArrayList<Ingredient>());

        fries = new Food(
            "Fries",
            3.00,
            new ArrayList<Ingredient>());
    }


    /**
     * Tests that a new order is empty.
     */
    public void testEmptyOrder()
    {
        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests adding a food item to the order.
     */
    public void testAddItem()
    {
        order.addItem(burger);

        assertEquals(1, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
    }


    /**
     * Tests adding multiple food items.
     */
    public void testAddMultipleItems()
    {
        order.addItem(burger);
        order.addItem(fries);

        assertEquals(2, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
        assertEquals(fries, order.getItems().get(1));
    }


    /**
     * Tests that duplicate food items can be added.
     */
    public void testAddDuplicateItems()
    {
        order.addItem(fries);
        order.addItem(fries);

        assertEquals(2, order.getItems().size());
        assertEquals(fries, order.getItems().get(0));
        assertEquals(fries, order.getItems().get(1));
    }


    /**
     * Tests that a null food item is not added.
     */
    public void testAddNullItem()
    {
        order.addItem(null);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests removing a food item from the order.
     */
    public void testRemoveItem()
    {
        order.addItem(burger);
        order.addItem(fries);
        order.removeItem(burger);

        assertEquals(1, order.getItems().size());
        assertEquals(fries, order.getItems().get(0));
    }


    /**
     * Tests removing an item that is not in the order.
     */
    public void testRemoveMissingItem()
    {
        order.addItem(burger);
        order.removeItem(fries);

        assertEquals(1, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
    }


    /**
     * Tests that removing a duplicate removes one occurrence.
     */
    public void testRemoveDuplicateItem()
    {
        order.addItem(fries);
        order.addItem(fries);
        order.removeItem(fries);

        assertEquals(1, order.getItems().size());
    }


    /**
     * Tests the total of an empty order.
     */
    public void testEmptyTotal()
    {
        assertEquals(0.0, order.getTotal(), 0.001);
    }


    /**
     * Tests calculating the total of one food item.
     */
    public void testSingleItemTotal()
    {
        order.addItem(burger);
        assertEquals(8.50, order.getTotal(), 0.001);
    }


    /**
     * Tests calculating the total of multiple food items.
     */
    public void testMultipleItemTotal()
    {
        order.addItem(burger);
        order.addItem(fries);

        assertEquals(11.50, order.getTotal(), 0.001);
    }


    /**
     * Tests that duplicate items are included in the total.
     */
    public void testDuplicateItemTotal()
    {
        order.addItem(fries);
        order.addItem(fries);

        assertEquals(6.00, order.getTotal(), 0.001);
    }
}