package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder() {
        return orderService.placeOrder();
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}
