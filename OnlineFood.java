// Interface
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Qty: " + quantity);
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    public String getDiscountDetails() {
        return "Veg Discount Applied: Rs." + discount;
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 50;
    private double discount = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + extraCharge) - discount;
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount Applied: Rs." + discount;
    }
}


public class OnlineFood {
    public static void main(String[] args) {
        FoodItem[] order = {
                new VegItem("Paneer Tikka", 250, 2),
                new NonVegItem("Chicken Curry", 400, 1)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            Discountable d = (Discountable) item;
            d.applyDiscount(10);
            System.out.println(d.getDiscountDetails());
            System.out.println("Final Price: Rs." + item.calculateTotalPrice());
            System.out.println("-----------------------------");
        }
    }
}
