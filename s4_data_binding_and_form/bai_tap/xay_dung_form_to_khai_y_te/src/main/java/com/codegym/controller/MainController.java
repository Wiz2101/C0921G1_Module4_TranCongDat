package com.codegym.controller;


import com.codegym.model.Person;
import com.codegym.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    IPersonService personService;
    @GetMapping("/create")
    public String showCreate(Model model){
        List<String> genderList = new ArrayList<>();
        genderList.add("Nam");
        genderList.add("Nu");
        genderList.add("Khac");
        model.addAttribute("genderList",genderList);
        model.addAttribute("person",new Person());
        return "create";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        List<Person> personList = personService.findAll();
        model.addAttribute("personList",personList);
        return "list";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute Person person){
        personService.createPerson(person);
        return "redirect:/list";
    }
}
