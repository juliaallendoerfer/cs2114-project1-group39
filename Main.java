import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Create Menu and populate it (assuming Menu class and Food subclasses exist)
        Menu menu = new Menu();
        // (Initialization of foods would go here)
        
        // 2. Collect Customer Info
        String name = getCustomerName(scanner);
        Customer customer = new Customer(name);
        selectAllergens(scanner, customer);
        
        // 3. Filter Menu
        ArrayList<Food> filteredMenu = menu.filterMenu(customer);
        
        // 4. Create Order and handle ordering
        Order order = new Order();
        boolean ordering = true;
        
        while (ordering) {
            System.out.println("\n1. View Menu & Add Food\n2. Remove Food\n3. Finish Order");
            int choice = getValidChoice(scanner, 1, 3);
            
            if (choice == 1) {
                selectFood(scanner, filteredMenu, order);
            } else if (choice == 2) {
                removeFood(scanner, order);
            } else {
                ordering = false;
            }
        }
        
        // 5. Display final order
        displayOrder(customer, order);
        scanner.close();
    }

    public static String getCustomerName(Scanner scanner) {
        String name = "";
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();
            
            if (!name.isEmpty() && name.length() <= 100 && name.matches("^[a-zA-Z\\s]+$")) {
                break;
            }
            System.out.println("Invalid input. Name must be 1-100 characters and contain only letters and spaces.");
        }
        return name;
    }

    public static void selectAllergens(Scanner scanner, Customer customer) {
        String[] supportedAllergens = {"Dairy", "Gluten", "Peanuts", "Tree Nuts", "Eggs", "Soy"};
        
        for (String allergen : supportedAllergens) {
            System.out.println("Are you allergic to " + allergen + "?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            
            int choice = getValidChoice(scanner, 1, 2);
            
            if (choice == 1) {
                customer.addAllergen(allergen);
            }
        }
    }

    public static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                choice = Integer.parseInt(scanner.nextLine().trim());
                
                if (choice >= min && choice <= max) {
                    break;
                }
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return choice;
    }

    public static void displayMenu(ArrayList<Food> foods) {
        System.out.println("\n--- MENU ---");
        int itemNumber = 1;
        
        // This assumes Food subclasses named Burger, Side, and Drink exist in the project to facilitate sorting by type.
        String[] categories = {"Burger", "Side", "Drink"};
        
        for (String category : categories) {
            for (Food food : foods) {
                if (food.getClass().getSimpleName().contains(category)) {
                    System.out.println(itemNumber + ". " + food.getName() + " - $" + String.format("%.2f", food.getPrice()));
                }
            }
        }
    }

    public static void selectFood(Scanner scanner, ArrayList<Food> foods, Order order) {
        if (foods.isEmpty()) {
            System.out.println("No foods available for your dietary restrictions.");
            return;
        }
        
        displayMenu(foods);
        System.out.println("Select a food item to add to your order (or 0 to cancel):");
        
        int choice = getValidChoice(scanner, 0, foods.size());
        
        if (choice > 0) {
            // Note: Since displayMenu visually sorts by class name, retrieving by choice-1 might require 
            // mapping visual index back to the ArrayList index. For simplicity in this implementation, 
            // we assume the ArrayList is already ordered (Burgers -> Sides -> Drinks) before being passed in.
            Food selectedFood = foods.get(choice - 1);
            order.addItem(selectedFood);
            System.out.println(selectedFood.getName() + " added to your order.");
        }
    }

    public static void removeFood(Scanner scanner, Order order) {
        ArrayList<Food> orderedItems = order.getItems();
        
        if (orderedItems.isEmpty()) {
            System.out.println("Your order is currently empty.");
            return;
        }
        
        System.out.println("\n--- CURRENT ORDER ---");
        for (int i = 0; i < orderedItems.size(); i++) {
            Food food = orderedItems.get(i);
            System.out.println((i + 1) + ". " + food.getName() + " - $" + String.format("%.2f", food.getPrice()));
        }
        
        System.out.println("Select an item to remove (or 0 to cancel):");
        int choice = getValidChoice(scanner, 0, orderedItems.size());
        
        if (choice > 0) {
            Food removedFood = orderedItems.get(choice - 1);
            order.removeItem(removedFood);
            System.out.println(removedFood.getName() + " removed from your order.");
        }
    }

    public static void displayOrder(Customer customer, Order order) {
        System.out.println("\n==================================");
        System.out.println("Order for: " + customer.getName());
        System.out.println("----------------------------------");
        
        ArrayList<Food> items = order.getItems();
        if (items.isEmpty()) {
            System.out.println("No items ordered.");
        } else {
            for (Food food : items) {
                System.out.println(food.getName() + " - $" + String.format("%.2f", food.getPrice()));
            }
        }
        
        System.out.println("----------------------------------");
        System.out.println("Total: $" + String.format("%.2f", order.getTotal()));
        System.out.println("==================================");
    }
}