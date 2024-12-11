package com.example.qp.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qp.model.GroceryItem;
import com.example.qp.model.Orders;
import com.example.qp.repository.GroceryItemRepository;
import com.example.qp.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
    private OrderRepository orderRepository;
	@Autowired
    private GroceryItemRepository groceryItemRepository;

    public Orders placeOrder(Map<Long, Integer> items) {
        Orders order = new Orders();
        order.setOrderDate(LocalDateTime.now());
        order.setGroceryItemQuantities(items);

        // Reduce inventory
        items.forEach((id, qty) -> {
            GroceryItem item = groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
            if (item.getQuantity() < qty) {
                throw new RuntimeException("Insufficient stock for item: " + item.getName());
            }
            item.setQuantity(item.getQuantity() - qty);
            groceryItemRepository.save(item);
        });

        return orderRepository.save(order);
    }
}