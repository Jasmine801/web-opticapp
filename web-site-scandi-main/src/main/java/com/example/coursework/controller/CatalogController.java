package com.example.coursework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CatalogController {

    @GetMapping()
    public String getMain() {
        return "index";
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/sale")
    public String getSale() {
        return "sale";
    }

    @GetMapping("/diop")
    public String getDiop() {
        return "diop";
    }

    @GetMapping("/sunsafe")
    public String getSunsafe() {
        return "sunsafe";
    }
}
