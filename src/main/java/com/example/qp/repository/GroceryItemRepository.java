package com.example.qp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.qp.model.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}