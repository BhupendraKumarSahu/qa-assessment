package com.example.qp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qp.model.GroceryItem;
import com.example.qp.model.Orders;
import com.example.qp.service.GroceryService;
import com.example.qp.service.OrderService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
    private GroceryService groceryService;
	@Autowired
    private OrderService orderService;

    @GetMapping("/grocery")
    public List<GroceryItem> viewGroceryItems() {
        return groceryService.getAllItems();
    }

    @PostMapping("/order")
    public Orders placeOrder(@RequestBody Map<Long, Integer> items) {
        return orderService.placeOrder(items);
    }
}