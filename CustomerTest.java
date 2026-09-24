import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Customer class.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class CustomerTest
{
    // ~ Fields ................................................................
    private Customer customer;

    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        customer = new Customer("Lovesh Kataria");
    }


    /**
     * Tests getName.
     */
    public void testGetName()
    {
        assertEquals("Lovesh Kataria", customer.getName());
    }


    /**
     * Tests that a new customer has no allergens.
     */
    public void testEmptyAllergens()
    {
        assertEquals(0, customer.getAllergens().size());
    }


    /**
     * Tests adding an allergen.
     */
    public void testAddAllergen()
    {
        customer.addAllergen("Dairy");
        assertEquals(1, customer.getAllergens().size());
        assertEquals("Dairy", customer.getAllergens().get(0));
    }


    /**
     * Tests adding multiple allergens.
     */
    public void testAddMultipleAllergens()
    {
        customer.addAllergen("Dairy");
        customer.addAllergen("Soy");

        assertEquals(2, customer.getAllergens().size());
        assertEquals("Dairy", customer.getAllergens().get(0));
        assertEquals("Soy", customer.getAllergens().get(1));
    }


    /**
     * Tests hasAllergen when the customer has the allergen.
     */
    public void testHasAllergen()
    {
        customer.addAllergen("Dairy");
        assertEquals(true, customer.hasAllergen("Dairy"));
    }


    /**
     * Tests hasAllergen when the customer does not have the allergen.
     */
    public void testDoesNotHaveAllergen()
    {
        customer.addAllergen("Dairy");
        assertEquals(false, customer.hasAllergen("Soy"));
    }


    /**
     * Tests case-insensitive allergen checking.
     */
    public void testHasAllergenCaseInsensitive()
    {
        customer.addAllergen("Dairy");
        assertEquals(true, customer.hasAllergen("dairy"));
    }


    /**
     * Tests checking for a null allergen.
     */
    public void testHasNullAllergen()
    {
        assertEquals(false, customer.hasAllergen(null));
    }
}