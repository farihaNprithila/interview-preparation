package serializationdeserialization.service;


import org.springframework.stereotype.Service;
import serializationdeserialization.entity.Order;
import serializationdeserialization.entity.Product;
import serializationdeserialization.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyDataService {

    // Generate dummy Users
    public List<User> getDummyUsers() {
        List<User> users = new ArrayList<>();
        
        users.add(new User(1L, "user1", "user1@email.com", "password123"));
        users.add(new User(2L, "user2", "user2@email.com", "password123"));
        users.add(new User(3L, "user3", "user3@email.com", "password123"));
        
        return users;
    }

    // Generate dummy Products
    public List<Product> getDummyProducts() {
        List<Product> products = new ArrayList<>();
        
        products.add(new Product(1L, "Product 1", 100.0, "Description of Product 1"));
        products.add(new Product(2L, "Product 2", 200.0, "Description of Product 2"));
        products.add(new Product(3L, "Product 3", 300.0, "Description of Product 3"));
        
        return products;
    }

    // Generate dummy Orders
    public List<Order> getDummyOrders() {
        List<Order> orders = new ArrayList<>();
        
        orders.add(new Order(1L, 1L, 1L, "Completed"));
        orders.add(new Order(2L, 2L, 2L, "Pending"));
        orders.add(new Order(3L, 3L, 3L, "Shipped"));
        
        return orders;
    }
}
