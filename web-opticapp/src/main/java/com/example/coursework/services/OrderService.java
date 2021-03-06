package com.example.coursework.services;

import com.example.coursework.entities.Order;
import com.example.coursework.repos.OrderRepository;
import com.example.coursework.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrdersByLogin(String name){
        return orderRepository
                .findOrdersByUserid(userRepository
                        .findUserByLogin(name).getId());
    }

    public void addNewOrder(Order newOrder, String name) {
        newOrder.setUserid(userRepository
                .findUserByLogin(name).getId());
        orderRepository.save(newOrder);
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public void delOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
