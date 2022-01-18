package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/customer")
    public String findAll(Model model) {
        List<Customer> customerList = customerService.findAll();
            model.addAttribute("customerList", customerList);
        return "/list";
    }

    @GetMapping("/customer/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/customer/create")
    public String addOrUpdate(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveOrUpdate(customer);
        redirectAttributes.addFlashAttribute("msgSC", "Add new Customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("customer/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/edit";
    }

    @PostMapping("customer/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.edit(customer);
        redirectAttributes.addFlashAttribute("msgEdit","Edit successfully!");
        return "redirect:/customer";
    }

    @GetMapping("customer/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msgDel", "Delete successfully!");
        return "redirect:/customer";
    }
}
