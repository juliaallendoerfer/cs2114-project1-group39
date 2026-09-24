import java.util.ArrayList;

/**
 * Represents a customer and stores the customer's name
 * and selected food allergens.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class Customer
{
    

    private String customerName;
    private ArrayList<String> allergens;

    /**
     * Creates a customer with the specified name
     * and an empty list of allergens.
     *
     * @param customerName the name of the customer
     */
    public Customer(String customerName)
    {
        this.customerName = customerName;
        allergens = new ArrayList<String>();
    }

    /**
     * Returns the customer's name.
     *
     * @return the name of the customer
     */
    public String getName()
    {
        return customerName;
    }

    /**
     * Adds an allergen to the customer's list of allergens.
     *
     * @param allergen the allergen to add
     */
    public void addAllergen(String allergen)
    {
        allergens.add(allergen);
    }

    /**
     * Checks whether the customer has the specified allergen.
     *
     * @param allergen the allergen to check
     * @return true if the customer has the allergen; false otherwise
     */
    public boolean hasAllergen(String allergen)
    {
        if (allergen == null)
        {
            return false;
        }

        for (String customerAllergen : allergens)
        {
            if (customerAllergen.equalsIgnoreCase(allergen))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the customer's list of allergens.
     *
     * @return the customer's allergens
     */
    public ArrayList<String> getAllergens()
    {
        return allergens;
    }

    
}