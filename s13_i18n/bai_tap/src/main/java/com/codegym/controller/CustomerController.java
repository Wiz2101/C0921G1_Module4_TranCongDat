package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping
    public String findAll(Model model){
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "views/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "views/create";
    }

    @PostMapping("/create")
    public String addOrUpdate(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msgSC", "Add new Customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "views/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msgEdit","Edit successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("msgDel", "Delete successfully!");
        return "redirect:/customer";
    }
}
