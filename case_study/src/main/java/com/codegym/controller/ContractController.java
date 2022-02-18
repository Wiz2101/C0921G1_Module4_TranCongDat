package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping
    public String findAll(Pageable pageable, Model model){
        Page<Contract> contractList = contractService.findAll(pageable);
        model.addAttribute("contractList",contractList);
        return "contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("createSC","Create Successfully!");
        return "redirect:/contract";
    }
}
