package com.example.coursework.repos;

import com.example.coursework.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUserid(Long id);
}
