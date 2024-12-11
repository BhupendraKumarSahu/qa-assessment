package com.example.qp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.qp.model.GroceryItem;
import com.example.qp.repository.GroceryItemRepository;

@Service
public class GroceryService {
	@Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem item) {
        GroceryItem existing = groceryItemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item not found"));
        existing.setName(item.getName());
        existing.setPrice(item.getPrice());
        existing.setQuantity(item.getQuantity());
        return groceryItemRepository.save(existing);
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}