public class Clothing extends Product {
    private String size;
    private String gender;
    private String color;
    
    //Constructors
    public Clothing() {
        super();
        this.size = "none";
        this.gender = "none";
        this.color = "none";
    }

    public Clothing(String id, String name, String description, double price, int quantity, String size, String gender, String color) {
        super(id, name, description, price, quantity);
        this.size = size;
        this.gender = gender;
        this.color = color;
    }

    //Getters
    public String getSize() {
        return this.size;
    }

    public String getGender() {
        return this.gender;
    }

    public String getColor() {
        return this.color;
    }

    //Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Methods
    @Override
    public String toString() {
        return super.toString() + String.format("\nSize: %s\nGender: %s\nColor: %s", this.size, this.gender, this.color);
    }
}
