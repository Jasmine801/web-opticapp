package com.example.coursework.controller;


import com.example.coursework.entities.Order;
import com.example.coursework.repos.OrderRepository;
import com.example.coursework.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class InformationController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/information")
    public String getInformation(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        Order newOrder = new Order();
        List<Order> orders = orderRepository.findOrdersByUserid(userRepository.findUserByLogin(currentUser.getUsername()).getId());
        model.addAttribute("newOrder", newOrder);
        model.addAttribute("orders", orders);

        return "information";
    }

    @GetMapping("/addOrder")
    public String order(Model model) {

        return "information";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("newOrder") Order newOrder, @AuthenticationPrincipal UserDetails currentUser) {

        newOrder.setUserid(userRepository.findUserByLogin(currentUser.getUsername()).getId());
        orderRepository.save(newOrder);

        return "redirect:information";
    }
}
