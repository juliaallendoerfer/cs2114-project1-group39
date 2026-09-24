import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest extends student.TestCase {

    private Scanner createScannerWithInput(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testGetCustomerName_ValidInput() {
        Scanner scanner = createScannerWithInput("John Doe\n");
        String name = Main.getCustomerName(scanner);
        assertEquals("John Doe", name);
    }

    @Test
    public void testGetCustomerName_InvalidThenValidInput() {
        Scanner scanner = createScannerWithInput("\nJohn123\nJane Smith\n");
        String name = Main.getCustomerName(scanner);
        assertEquals("Jane Smith", name);
    }

    @Test
    public void testGetValidChoice_ValidRange() {
        Scanner scanner = createScannerWithInput("abc\n0\n5\n2\n"); 
        int choice = Main.getValidChoice(scanner, 1, 3);
        assertEquals(2, choice);
    }

    @Test
    public void testSelectAllergens() {
        Scanner scanner = createScannerWithInput("1\n2\n2\n2\n2\n2\n");
        Customer customer = new Customer("Test User");
        
        Main.selectAllergens(scanner, customer);
        ArrayList<String> customerAllergens = customer.getAllergens();
        assertEquals(1, customerAllergens.size());
        assertTrue(customerAllergens.contains("Dairy"));
    }
}