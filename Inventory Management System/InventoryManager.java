import java.util.ArrayList;
public class InventoryManager {
    private ArrayList<Product> inventory;

    //Constructor
    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    //Add product
    public void addProduct(Product product) {
        if (product.getID().equals("none")) {
            System.out.println("Product information must be filled out before adding!");
        }
        else {
            inventory.add(product);
        }
    }

    //Remove product
    public boolean removeProduct(String ID) {
        for (Product p : inventory) {
            if(p.getID().equals(ID)) {
                inventory.remove(p);
                return true;
            }
        }
        return false;
    }

    //Find product
    public Product findProduct(String ID) {
        for (Product p : inventory) {
            if(p.getID().equals(ID)) {
                return p;
            }
        }
        return null;
    }

    //Display products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
        }
        else {
            for (Product p : inventory) {
                System.out.println(p);
                System.out.println("-------------------------------");
            }
        }
    }

    //List only clothing products
    public void listClothingProducts() {
        for (Product p : inventory) {
            if (p instanceof Clothing) {
                System.out.println(p);
                System.out.println("-------------------------------");
            }
        }
    }

    //Restock a Product
    public boolean restockProduct(String id, int amount) {
        for (Product p : inventory) {
                if (p.getID().equals(id)) {
                    p.increaseQuantity(amount);
                    return true;
                }
            }
        System.out.println("Product not found or inventory is empty.");
        return false;
    }

    //Reduce stock of a Product
    public boolean reduceStock(String id, int amount) {
        for (Product p : inventory) {
            if (p.getID().equals(id)) {
                p.decreaseQuantity(amount);
                return true;
            }
        }
        System.out.println("Product not found or inventory is empty.");
        return false;
    }

    //Get total inventory value
    public double getTotalInventoryValue() {
        if (inventory.isEmpty()) {
            return 0.0;
        }
        else {
            double totalValue = 0.0;
            for (Product p : inventory) {
                totalValue += p.getTotalValue();
            }
            return totalValue;
        }
    }
}
