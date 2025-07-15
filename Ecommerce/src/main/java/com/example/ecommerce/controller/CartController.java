package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired private CartService cartService;

    @GetMapping
    public Cart viewCart() {
        return cartService.getCart();
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addItem(productId, quantity);
    }

    @PutMapping("/update")
    public Cart updateItem(@RequestParam Long itemId, @RequestParam int quantity) {
        return cartService.updateItem(itemId, quantity);
    }

    @DeleteMapping("/remove")
    public Cart removeItem(@RequestParam Long itemId) {
        return cartService.removeItem(itemId);
    }

    @DeleteMapping("/clear")
    public Cart clearCart() {
        return cartService.clearCart();
    }
}
