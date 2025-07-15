package com.example.ecommerce.service;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    @Autowired private UserRepository userRepository;
    @Autowired private CartRepository cartRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private CartItemRepository cartItemRepository;

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username).orElseThrow();
    }

    public Cart getCart() {
        User user = getCurrentUser();
        return cartRepository.findByUser(user).orElseGet(() -> {
            Cart cart = new Cart(user);
            return cartRepository.save(cart);
        });
    }

    public Cart addItem(Long productId, int quantity) {
        Cart cart = getCart();
        Product product = productRepository.findById(productId).orElseThrow();

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                return cartRepository.save(cart);
            }
        }

        CartItem item = new CartItem(product, quantity, cart);
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart updateItem(Long itemId, int quantity) {
        CartItem item = cartItemRepository.findById(itemId).orElseThrow();
        item.setQuantity(quantity);
        cartItemRepository.save(item);
        return getCart();
    }

    public Cart removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
        return getCart();
    }

    public Cart clearCart() {
        Cart cart = getCart();
        cart.getItems().clear();
        return cartRepository.save(cart);
    }
}
