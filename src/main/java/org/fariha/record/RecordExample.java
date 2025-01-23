package org.fariha.record;

public class RecordExample {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1200.99, "Electronics");

        // Using generated methods
        System.out.println(product.name());  // Output: Laptop
        System.out.println(product.price()); // Output: 1200.99
        System.out.println(product);         // Output: Product[name=Laptop, price=1200.99, category=Electronics]

        // `equals` and `hashCode`
        Product anotherProduct = new Product("Laptop", 1200.99, "Electronics");
        System.out.println(product.equals(anotherProduct)); // Output: true
    }
}
