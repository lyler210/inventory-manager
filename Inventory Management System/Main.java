import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        System.out.println("Welcome to the Inventory Manager!");
        while (on) {
            System.out.println("<-> INVENTORY MENU <->");
            System.out.println("a - Add Product to inventory");
            System.out.println("d - Delete Product from inventory");
            System.out.println("c - Increase product stock");
            System.out.println("r - Reduce Product stock");
            System.out.println("v - View all products");
            System.out.println("t - Get total inventory value");
            System.out.println("f - Find product");
            System.out.println("q - Quit");
            System.out.print("Enter your choice: ");

            char userChoice;
            userChoice = sc.next().charAt(0);
            sc.nextLine();

            switch (userChoice) {
                case 'a':
                    System.out.print("Is this a clothing product? (yes / no): ");
                    String isClothing = sc.nextLine();
                    System.out.println("<-> ADDING A PRODUCT <->");
                    System.out.print("Enter product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter product description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if (isClothing.equalsIgnoreCase("yes")) {
                        System.out.print("Enter clothing size: ");
                        String size = sc.nextLine();
                        System.out.print("Enter gender: ");
                        String gender = sc.nextLine();
                        System.out.print("Enter color: ");
                        String color = sc.nextLine();
                        
                        Clothing clothing = new Clothing(id, name, description, price, quantity, size, gender, color);
                        manager.addProduct(clothing);
                    }
                    else {
                        Product product = new Product(id, name, description, price, quantity);
                        manager.addProduct(product);
                    }
                    break;
                
                case 'd':
                    System.out.println("<-> DELETING A PRODUCT <->");
                    System.out.print("Enter product ID: ");
                    String removeId = sc.nextLine();
                    if (manager.removeProduct(removeId)) {
                        System.out.println("Product removed successfully.");
                    }
                    else {
                        System.out.println("Product not found.");
                    }
                    break;
                
                case 'c':
                    System.out.println("<-> INCREASING PRODUCT STOCK <->");
                    System.out.print("Enter product ID: ");
                    String increaseId = sc.nextLine();
                    System.out.print("Enter how much stock was added: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    if (manager.restockProduct(increaseId, stock)) {
                        System.out.println("Restock was successful.");
                    }
                    else {
                        System.out.println("Someething went wrong...");
                    }
                    break;
                
                case 'r':
                    System.out.println("<-> REDUCING PRODUCT STOCK <->");
                     System.out.print("Enter product ID: ");
                    String decreaseId = sc.nextLine();
                    System.out.print("Enter how much stock was removed: ");
                    int reducedStock = sc.nextInt();
                    sc.nextLine();
                    if (manager.reduceStock(decreaseId, reducedStock)) {
                        System.out.println("Successfully reduced stock.");
                    }
                    else {
                        System.out.println("Someething went wrong...");
                    }
                    break;

                case 'v':
                    System.out.println("<-> INVENTORY DETAILS <->");
                    manager.displayInventory();
                    break;
                
                case 't':
                    System.out.println("<-> TOTAL INVENTORY VALUE <->");
                    System.out.printf("Value: $%.2f%n", manager.getTotalInventoryValue());
                    break;

                case 'f':
                System.out.println("<-> FIND A PRODUCT <->");
                System.out.print("Enter product ID: ");
                    String findId = sc.nextLine();
                    Product p = manager.findProduct(findId);
                    if (p != null) {
                        System.out.println(p);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 'q':
                    on = false;
                    System.out.println("Closing Inventory Manager...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        sc.close();
    }
}
