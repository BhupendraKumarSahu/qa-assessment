package com.example.qp.model;

import java.time.LocalDateTime;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    @ElementCollection
    private Map<Long, Integer> groceryItemQuantities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Map<Long, Integer> getGroceryItemQuantities() {
		return groceryItemQuantities;
	}

	public void setGroceryItemQuantities(Map<Long, Integer> groceryItemQuantities) {
		this.groceryItemQuantities = groceryItemQuantities;
	}
}