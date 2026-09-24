import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Order class.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class OrderTest
{
    // ~ Fields ................................................................
    private Order order;
    private Food burger;
    private Food fries;


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        order = new Order();

        burger = new Food(
            "Cheese Burger",
            8.50,
            new java.util.ArrayList<Ingredient>());

        fries = new Food(
            "Fries",
            3.00,
            new java.util.ArrayList<Ingredient>());
    }


    /**
     * Tests that a new order is empty.
     */
    @Test
    public void testEmptyOrder()
    {
        setUp();

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests adding a food item to the order.
     */
    @Test
    public void testAddItem()
    {
        setUp();

        order.addItem(burger);

        assertEquals(1, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
    }


    /**
     * Tests adding multiple food items.
     */
    @Test
    public void testAddMultipleItems()
    {
        setUp();

        order.addItem(burger);
        order.addItem(fries);

        assertEquals(2, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
        assertEquals(fries, order.getItems().get(1));
    }


    /**
     * Tests that duplicate food items can be added.
     */
    @Test
    public void testAddDuplicateItems()
    {
        setUp();

        order.addItem(fries);
        order.addItem(fries);

        assertEquals(2, order.getItems().size());
        assertEquals(fries, order.getItems().get(0));
        assertEquals(fries, order.getItems().get(1));
    }


    /**
     * Tests that a null food item is not added.
     */
    @Test
    public void testAddNullItem()
    {
        setUp();

        order.addItem(null);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests removing a food item from the order.
     */
    @Test
    public void testRemoveItem()
    {
        setUp();

        order.addItem(burger);
        order.addItem(fries);
        order.removeItem(burger);

        assertEquals(1, order.getItems().size());
        assertEquals(fries, order.getItems().get(0));
    }


    /**
     * Tests removing an item that is not in the order.
     */
    @Test
    public void testRemoveMissingItem()
    {
        setUp();

        order.addItem(burger);
        order.removeItem(fries);

        assertEquals(1, order.getItems().size());
        assertEquals(burger, order.getItems().get(0));
    }


    /**
     * Tests that removing a duplicate removes one occurrence.
     */
    @Test
    public void testRemoveDuplicateItem()
    {
        setUp();

        order.addItem(fries);
        order.addItem(fries);
        order.removeItem(fries);

        assertEquals(1, order.getItems().size());
    }


    /**
     * Tests the total of an empty order.
     */
    @Test
    public void testEmptyTotal()
    {
        setUp();

        assertEquals(0.0, order.getTotal(), 0.001);
    }


    /**
     * Tests calculating the total of one food item.
     */
    @Test
    public void testSingleItemTotal()
    {
        setUp();

        order.addItem(burger);

        assertEquals(8.50, order.getTotal(), 0.001);
    }


    /**
     * Tests calculating the total of multiple food items.
     */
    @Test
    public void testMultipleItemTotal()
    {
        setUp();

        order.addItem(burger);
        order.addItem(fries);

        assertEquals(11.50, order.getTotal(), 0.001);
    }


    /**
     * Tests that duplicate items are included in the total.
     */
    @Test
    public void testDuplicateItemTotal()
    {
        setUp();

        order.addItem(fries);
        order.addItem(fries);

        assertEquals(6.00, order.getTotal(), 0.001);
    }
}