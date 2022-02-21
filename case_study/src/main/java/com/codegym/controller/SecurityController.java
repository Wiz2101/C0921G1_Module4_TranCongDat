package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.User;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/login")
//@SessionAttributes("employee")
public class SecurityController {
    @Autowired
    IEmployeeService employeeService;

//    @ModelAttribute("user")
//    public User user(){
//        return new User();
//    }

    @GetMapping
    public String showLogin(){
        return "security/login";
    }

//    @PostMapping("/login")
//    public String findEmpByName(@ModelAttribute User user, Model model){
//        Employee employee = employeeService.findByUsers_User(user.getUser());
//        model.addAttribute("employee",employee);
//        return "index";
//    }
}
