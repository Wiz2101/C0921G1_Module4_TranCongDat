package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @GetMapping
    public String findAll(){
        return "blog";
    }

    @GetMapping("/category")
    public String findByCategory(){
        return "blog";
    }
}
