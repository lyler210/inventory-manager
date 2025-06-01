public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    //Constructors
    public Product() {
        this.id = "none";
        this.name = "none";
        this.description = "none";
        this.price = 0.0;
        this.quantity = 0;
    }
    public Product(String id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        if (price < 0) {
            System.out.println("Price cannot be less than 0. Setting price to 0.");
            this.price = 0;
        }
        else {
            this.price = Math.round(price*100.0) / 100.0;
        }
        if (quantity < 0) {
            System.out.println("Invalid quantity input. Setting quantity to 0");
            this.quantity = 0;
        }
        else {
            this.quantity = quantity;
        }
    }

    public Product(Product p) {
        this.id = p.id;
        this.name = p.name;
        this.description = p.description;
        this.price = p.price;
        this.quantity = p.quantity;
    }

    //Getters
    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalValue() {
        return Math.round(this.price*this.quantity*100.0) / 100.0;
    }

    //Setters
    public void setID(String newID) {
        this.id = newID;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDesc) {
        this.description = newDesc;
    }

    public void setPrice(float newPrice) {
        if (newPrice < 0) {
            System.out.println("Invalid price. Price unchanged.");
        }
        else {
            this.price = Math.round(newPrice*100.0) / 100.0;
        }
    }

    public void setQuantity(int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Invalid quantity. Quantity unchanged.");
        }
        else {
            this.quantity = newQuantity;
        }
    }

    //Methods
    @Override
    public String toString() {
        return String.format(
            "ID: %s\nName: %s\nDescription: %s\nPrice: $%.2f\nQuantity: %d\nTotal Value: $%.2f",
            this.id, this.name, this.description, this.price, this.quantity, getTotalValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int compareTo(Product other) {
        return this.id.compareTo(other.id);
    }

    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid input. Quantity unchanged");
        }
        else {
            this.quantity += amount;
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid input. Quantity unchanged");
        }
        else if (amount > this.quantity) {
            System.out.println("Amount entered will result in negative quantity! Quantity unchanged.");
        }
        else {
            this.quantity -= amount;
        }
    }
}
