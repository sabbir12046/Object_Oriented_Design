//*************************************************************************
// TITLE : A java program to demonstrate Open Close Principle.
// AUTHOR : MD Sabbir Hasan, UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************



import java.util.ArrayList;
import java.util.List;

/**
 * Interface defining a product.
 */
interface Product {
    String getName();
    double getPrice();
}

/**
 * Class representing a physical product.
 */
class PhysicalProduct implements Product {
    private String name;
    private double price;

    public PhysicalProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

/**
 * Class representing a digital product.
 */
class DigitalProduct implements Product {
    private String name;
    private double price;

    public DigitalProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

/**
 * Class representing a shop that sells products.
 */
class Shop {
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the shop.
     *
     * @param product The product to be added to the shop
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Calculates the total price of all products in the shop.
     *
     * @return The total price of all products in the shop
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

public class Open_close_principle {
    public static void main(String[] args) {
        // Create a shop
        Shop shop = new Shop();

        // Add physical products to the shop
        shop.addProduct(new PhysicalProduct("Laptop", 1000));
        shop.addProduct(new PhysicalProduct("Mobile Phone", 500));

        // Add digital products to the shop
        shop.addProduct(new DigitalProduct("E-book", 10));
        shop.addProduct(new DigitalProduct("Software", 50));

        // Calculate total price of all products in the shop
        double totalPrice = shop.calculateTotalPrice();
        System.out.println("Total price of all products: $" + totalPrice);
    }
}
