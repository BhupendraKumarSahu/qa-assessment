package com.example.qp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.qp.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}