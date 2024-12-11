package com.example.qp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qp.model.GroceryItem;
import com.example.qp.service.GroceryService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
    private GroceryService groceryService;

    @PostMapping("/grocery")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryService.addGroceryItem(item);
    }

    @GetMapping("/grocery")
    public List<GroceryItem> viewGroceryItems() {
        return groceryService.getAllItems();
    }

    @PutMapping("/grocery/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return groceryService.updateGroceryItem(id, item);
    }

    @DeleteMapping("/grocery/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryService.deleteGroceryItem(id);
    }
}