/**
 * Represents an ingredient used in a food item and provides
 * information about supported food allergens.
 *
 * @author Lovesh Kataria
 * @version 2026.09.24
 */
public class Ingredient
{
    private String name;
    
    private static final String[] dairyAllergen = { "milk", "cheese", "parmesan cheese", "ice cream" };
    private static final String[] glutenAllergen = { "bun", "wheat flour", "croutons" };
    private static final String[] peanutAllergen = {"peanuts", "peanut butter", "peanut oil"};
    private static final String[] treeNutAllergen = { "almonds", "cashews", "walnuts", "pecans", "hazelnuts" };
    private static final String[] eggAllergen = { "egg", "mayonnaise", "Caesar dressing" };
    private static final String[] soyAllergen = { "soy", "soybeans", "soy sauce", "tofu", "edamame" };


    /**
     * Creates an ingredient with the specified name.
     *
     * @param name the name of the ingredient
     */
    public Ingredient(String name)
    {
        this.name = name;
    }

    /**
     * Returns the ingredient's name.
     *
     * @return the name of the ingredient
     */
    public String getName()
    {
        return name;
    }

    /**
     * Checks whether this ingredient's name appears in an allergen list.
     *
     * @param allergenList the list of ingredients associated with an allergen
     * @return true if this ingredient appears in the list; false otherwise
     */
    private boolean isInAllergenList(String[] allergenList)
    {
        for (String ingredient : allergenList)
        {
            if (name.equalsIgnoreCase(ingredient))
            {
                return true;
            }
        }
        return false;
    }
    

    /**
     * Checks whether this ingredient is associated with the specified allergen.
     *
     * @param allergen the allergen to check
     * @return true if the ingredient is associated with the allergen;
     *         false otherwise
     */
    public boolean containsAllergen(String allergen)
    {
        if (allergen == null)
        {
            return false;
        }
        if (allergen.equalsIgnoreCase("Dairy"))
        {
            return isInAllergenList(dairyAllergen);
        }
        else if (allergen.equalsIgnoreCase("Gluten"))
        {
            return isInAllergenList(glutenAllergen);
        }
        else if (allergen.equalsIgnoreCase("Peanuts"))
        {
            return isInAllergenList(peanutAllergen);
        }
        else if (allergen.equalsIgnoreCase("Tree Nuts"))
        {
            return isInAllergenList(treeNutAllergen);
        }
        else if (allergen.equalsIgnoreCase("Eggs"))
        {
            return isInAllergenList(eggAllergen);
        }
        else if (allergen.equalsIgnoreCase("Soy"))
        {
            return isInAllergenList(soyAllergen);
        }

        return false;
    }
}

