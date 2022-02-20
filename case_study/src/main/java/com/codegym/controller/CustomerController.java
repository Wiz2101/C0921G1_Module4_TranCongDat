package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.*;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public String findAll(@RequestParam Optional<String> keyword, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customerList;
        if (!keyword.isPresent()) {
            customerList = customerService.findAll(pageable);
        } else {
            customerList = customerService.findByName(keyword.get(),pageable);
        }
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model, Pageable pageable) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerDto",customerDto);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("createSC", "Create Sucessfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model, Pageable pageable) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            return "error404";
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);
        model.addAttribute("customer", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());

        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerDto",customerDto);
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("UpdateSC","Update Successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("DeleteSC","Delete Successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String viewDetail(@PathVariable Long id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return "error404";
        }
        model.addAttribute("customer",customer);
        return "customer/detail";
    }

    @GetMapping("/inhouse-guest")
    public String showInhousePage(){
        return "/customer/inhouse_guest";
    }

    @GetMapping("/inhouse-guest/search")
    public String findAllInhouse(@RequestParam Optional<String> date, Model model, Pageable pageable){
        Page<Customer> customerList = customerService.findAllByDate(date.get(), pageable);
        model.addAttribute("customerList",customerList);
        return "customer/search_customer";
    }

}
