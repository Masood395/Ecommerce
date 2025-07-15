package com.example.ecommerce;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create admin user
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ROLE_ADMIN);
            userRepository.save(admin);
        }

        // Add sample products
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Laptop", "High-end gaming laptop", 1500.0));
            productRepository.save(new Product("Phone", "Latest smartphone", 800.0));
            productRepository.save(new Product("Headphones", "Noise-cancelling headphones", 200.0));
        }
    }
}
