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


    // ~ Constructors ..........................................................


    // ~ Public Methods ........................................................

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
    @Test
    public void testGetName()
    {
        setUp();
        assertEquals("Lovesh Kataria", customer.getName());
    }


    /**
     * Tests that a new customer has no allergens.
     */
    @Test
    public void testEmptyAllergens()
    {
        setUp();
        assertEquals(0, customer.getAllergens().size());
    }


    /**
     * Tests adding an allergen.
     */
    @Test
    public void testAddAllergen()
    {
        setUp();
        customer.addAllergen("Dairy");

        assertEquals(1, customer.getAllergens().size());
        assertEquals("Dairy", customer.getAllergens().get(0));
    }


    /**
     * Tests adding multiple allergens.
     */
    @Test
    public void testAddMultipleAllergens()
    {
        setUp();
        customer.addAllergen("Dairy");
        customer.addAllergen("Soy");

        assertEquals(2, customer.getAllergens().size());
        assertEquals("Dairy", customer.getAllergens().get(0));
        assertEquals("Soy", customer.getAllergens().get(1));
    }


    /**
     * Tests hasAllergen when the customer has the allergen.
     */
    @Test
    public void testHasAllergen()
    {
        setUp();
        customer.addAllergen("Dairy");

        assertEquals(true, customer.hasAllergen("Dairy"));
    }


    /**
     * Tests hasAllergen when the customer does not have the allergen.
     */
    @Test
    public void testDoesNotHaveAllergen()
    {
        setUp();
        customer.addAllergen("Dairy");

        assertEquals(false, customer.hasAllergen("Soy"));
    }


    /**
     * Tests case-insensitive allergen checking.
     */
    @Test
    public void testHasAllergenCaseInsensitive()
    {
        setUp();
        customer.addAllergen("Dairy");

        assertEquals(true, customer.hasAllergen("dairy"));
    }


    /**
     * Tests checking for a null allergen.
     */
    @Test
    public void testHasNullAllergen()
    {
        setUp();

        assertEquals(false, customer.hasAllergen(null));
    }
}