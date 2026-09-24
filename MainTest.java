import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tests the Main class.
 */
public class MainTest extends student.TestCase
{
    /**
     * Creates a scanner containing the specified input.
     *
     * @param input the input for the scanner
     * @return a scanner containing the input
     */
    private Scanner createScannerWithInput(String input)
    {
        return new Scanner(
            new ByteArrayInputStream(input.getBytes()));
    }


    /**
     * Tests getCustomerName with a valid name.
     */
    public void testGetCustomerName()
    {
        Scanner scanner = createScannerWithInput("John Doe\n");
        assertEquals("John Doe", Main.getCustomerName(scanner));
    }


    /**
     * Tests getCustomerName with invalid input followed
     * by a valid name.
     */
    public void testGetCustomerNameInvalidInput()
    {
        Scanner scanner =
            createScannerWithInput("\nJohn123\nJane Smith\n");
        assertEquals("Jane Smith", Main.getCustomerName(scanner));
    }


    /**
     * Tests that names containing hyphens and apostrophes
     * are accepted.
     */
    public void testGetCustomerNameSpecialCharacters()
    {
        Scanner scanner =
            createScannerWithInput("Mary-Jane O'Neil\n");

        assertEquals(
            "Mary-Jane O'Neil",
            Main.getCustomerName(scanner));
    }


    /**
     * Tests getValidChoice with valid input.
     */
    public void testGetValidChoice()
    {
        Scanner scanner = createScannerWithInput("2\n");
        assertEquals(2, Main.getValidChoice(scanner, 1, 3));
    }


    /**
     * Tests getValidChoice with invalid input followed
     * by a valid choice.
     */
    public void testGetValidChoiceInvalidInput()
    {
        Scanner scanner =
            createScannerWithInput("abc\n2.5\n0\n5\n2\n");

        assertEquals(2, Main.getValidChoice(scanner, 1, 3));
    }


    /**
     * Tests selecting allergens.
     */
    public void testSelectAllergens()
    {
        Scanner scanner =
            createScannerWithInput("1\n2\n2\n2\n2\n2\n");
        Customer customer = new Customer("Test User");

        Main.selectAllergens(scanner, customer);

        assertEquals(1, customer.getAllergens().size());
        assertEquals(
            "Dairy",
            customer.getAllergens().get(0));
    }


    /**
     * Tests selecting no allergens.
     */
    public void testSelectNoAllergens()
    {
        Scanner scanner =
            createScannerWithInput("2\n2\n2\n2\n2\n2\n");
        Customer customer = new Customer("Test User");

        Main.selectAllergens(scanner, customer);

        assertEquals(0, customer.getAllergens().size());
    }


    /**
     * Tests adding a food to an order.
     */
    public void testSelectFood()
    {
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(
            new Food(
                "Fries",
                3.00,
                new ArrayList<Ingredient>()));

        Order order = new Order();
        Scanner scanner = createScannerWithInput("1\n");

        Main.selectFood(scanner, foods, order);

        assertEquals(1, order.getItems().size());
        assertEquals("Fries", order.getItems().get(0).getName());
    }


    /**
     * Tests canceling food selection.
     */
    public void testSelectFoodCancel()
    {
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(
            new Food(
                "Fries",
                3.00,
                new ArrayList<Ingredient>()));

        Order order = new Order();
        Scanner scanner = createScannerWithInput("0\n");

        Main.selectFood(scanner, foods, order);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests selecting food when no foods are available.
     */
    public void testSelectFoodEmptyMenu()
    {
        ArrayList<Food> foods = new ArrayList<Food>();
        Order order = new Order();
        Scanner scanner = createScannerWithInput("");

        Main.selectFood(scanner, foods, order);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests removing a food from an order.
     */
    public void testRemoveFood()
    {
        Order order = new Order();
        Food fries = new Food(
            "Fries",
            3.00,
            new ArrayList<Ingredient>());
        order.addItem(fries);

        Scanner scanner = createScannerWithInput("1\n");

        Main.removeFood(scanner, order);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests canceling food removal.
     */
    public void testRemoveFoodCancel()
    {
        Order order = new Order();
        Food fries = new Food(
            "Fries",
            3.00,
            new ArrayList<Ingredient>());
        order.addItem(fries);

        Scanner scanner = createScannerWithInput("0\n");

        Main.removeFood(scanner, order);

        assertEquals(1, order.getItems().size());
    }


    /**
     * Tests removing food from an empty order.
     */
    public void testRemoveFoodEmptyOrder()
    {
        Order order = new Order();
        Scanner scanner = createScannerWithInput("");

        Main.removeFood(scanner, order);

        assertEquals(0, order.getItems().size());
    }


    /**
     * Tests displaying the final order.
     */
    public void testDisplayOrder()
    {
        Customer customer = new Customer("Test User");
        Order order = new Order();
        order.addItem(
            new Food(
                "Fries",
                3.00,
                new ArrayList<Ingredient>()));

        ByteArrayOutputStream output =
            new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try
        {
            Main.displayOrder(customer, order);
        }
        finally
        {
            System.setOut(originalOut);
        }

        String result = output.toString();

        assertEquals(true, result.contains("Test User"));
        assertEquals(true, result.contains("Fries"));
        assertEquals(true, result.contains("$3.00"));
    }


    /**
     * Tests displaying an empty order.
     */
    public void testDisplayEmptyOrder()
    {
        Customer customer = new Customer("Test User");
        Order order = new Order();

        ByteArrayOutputStream output =
            new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try
        {
            Main.displayOrder(customer, order);
        }
        finally
        {
            System.setOut(originalOut);
        }

        String result = output.toString();

        assertEquals(
            true,
            result.contains("No items ordered."));
        assertEquals(true, result.contains("$0.00"));
    }
}