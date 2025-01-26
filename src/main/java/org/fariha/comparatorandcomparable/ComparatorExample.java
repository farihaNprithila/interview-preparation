package org.fariha.comparatorandcomparable;

import java.util.*;

class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.name.compareTo(p2.name); // Alphabetical order
    }
}

class ProductIdComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p1.id, p2.id); // Numeric order
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(3, "Tablet", 600.75),
                new Product(1, "Laptop", 1200.50),
                new Product(2, "Phone", 800.00)
        );

        // Sorting by name
        Collections.sort(products, new ProductNameComparator());
        System.out.println("Sorted by Name:");
        products.forEach(System.out::println);

        // Sorting by id
        Collections.sort(products, new ProductIdComparator());
        System.out.println("\nSorted by ID:");
        products.forEach(System.out::println);
    }
}
