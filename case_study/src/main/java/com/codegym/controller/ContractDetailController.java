package com.codegym.controller;

import com.codegym.model.ContractDetail;
import com.codegym.service.IAttachServiceService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IContractService contractService;

    @Autowired
    IAttachServiceService attachServiceService;

    @GetMapping
    public String findAll(Model model){
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        model.addAttribute("contractDetailList",contractDetailList);
        return "contract_detail/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList",attachServiceService.findAll());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("createSC","Create Successfully!");
        return "redirect:/contract-detail";
    }
}
