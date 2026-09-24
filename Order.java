import java.util.ArrayList;

/**
 * Represents a customer's order and stores the food items
 * selected by the customer.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class Order
{

    private ArrayList<Food> items;

    /**
     * Creates an empty order.
     */
    public Order()
    {
        items = new ArrayList<Food>();
    }

    /**
     * Adds a food item to the order.
     *
     * @param food the food item to add
     */
    public void addItem(Food food)
    {
        if (food != null)
        {
            items.add(food);
        }
    }

    /**
     * Removes a food item from the order.
     *
     * @param food the food item to remove
     */
    public void removeItem(Food food)
    {
        items.remove(food);
    }

    /**
     * Returns the food items in the order.
     *
     * @return the list of food items in the order
     */
    public ArrayList<Food> getItems()
    {
        return items;
    }

    /**
     * Calculates and returns the total price of all food items
     * in the order.
     *
     * @return the total price of the order
     */
    public double getTotal()
    {
        double total = 0.0;

        for (Food food : items)
        {
            total += food.getPrice();
        }

        return total;
    }
}