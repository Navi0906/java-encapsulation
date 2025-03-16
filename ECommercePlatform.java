// Interface for Taxable Products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Common Method
    public abstract double calculateDiscount();
}

// Electronics Class implementing Taxable
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() { return getPrice() * 0.10; } // 10% discount
    public double calculateTax() { return getPrice() * 0.18; } // 18% GST
    public String getTaxDetails() { return "Electronics Tax: 18% GST"; }
}

// Clothing Class implementing Taxable
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() { return getPrice() * 0.20; }
    public double calculateTax() { return getPrice() * 0.12; }
    public String getTaxDetails() { return "Clothing Tax: 12% GST"; }
}

// Groceries Class - no Taxable implementation
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() { return getPrice() * 0.05; }
}


public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
                new Electronics(101, "Laptop", 70000),
                new Clothing(102, "T-Shirt", 1500),
                new Groceries(103, "Rice Bag", 800)
        };

        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Original Price: " + p.getPrice());
            System.out.println("Tax: " + tax);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            if (p instanceof Taxable) {
                System.out.println(((Taxable)p).getTaxDetails());
            }
            System.out.println("----------------------------");
        }
    }
}
