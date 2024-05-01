///*************************************************************************
// TITLE : A java program to demonstrate Single Responsibility principle
// AUTHOR : MD SABBIR HASAN, UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************


import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a product in the shop.
 */
class Product {
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a product with the given name, price, and quantity.
     *
     * @param name     The name of the product
     * @param price    The price of the product
     * @param quantity The quantity of the product
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the quantity of the product.
     *
     * @return The quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity The new quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

/**
 * This class represents a shop that sells products.
 */
class Shop {
    private List<Product> products;

    /**
     * Constructs a shop with an empty list of products.
     */
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
     * Sells a product from the shop.
     *
     * @param productName The name of the product to be sold
     * @param quantity    The quantity of the product to be sold
     * @return true if the product was sold successfully, false otherwise
     */
    public boolean sellProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName) && product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                return true;
            }
        }
        return false;
    }
}

public class Single_responsibility_principle {
    public static void main(String[] args) {
        // Create a shop
        Shop shop = new Shop();

        // Add products to the shop
        shop.addProduct(new Product("Laptop", 1000, 10));
        shop.addProduct(new Product("Mobile Phone", 500, 20));

        // Sell a product from the shop
        String productName = "Laptop";
        int quantity = 5;
        if (shop.sellProduct(productName, quantity)) {
            System.out.println(quantity + " " + productName + "(s) sold successfully.");
        } else {
            System.out.println("Failed to sell " + quantity + " " + productName + "(s).");
        }
    }
}
