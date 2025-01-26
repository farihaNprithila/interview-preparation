package org.fariha.comparatorandcomparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableExample2 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1200.50),
                new Product(2, "Phone", 800.00),
                new Product(3, "Tablet", 600.75)
        );

        // Natural sorting by price
        Collections.sort(products);
        products.forEach(System.out::println);
    }
}
