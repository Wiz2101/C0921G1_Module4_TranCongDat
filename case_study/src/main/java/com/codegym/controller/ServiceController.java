package com.codegym.controller;

import com.codegym.model.Service;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IServiceService;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IRentTypeService rentTypeService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @GetMapping
    public String findAll(Model model){
        List<Service> serviceList = serviceService.findAll();
        model.addAttribute("serviceList",serviceList);
        return "service/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("service",new Service());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("serviceTypeList",serviceTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService (@ModelAttribute Service service, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("createSC","Create Successfully!");
        return "redirect:/service";
    }

    @GetMapping("/delete/{id}")
    public String deleteService (@PathVariable Long id, RedirectAttributes redirectAttributes){
        serviceService.remove(id);
        redirectAttributes.addFlashAttribute("DeleteSC","Delete Successfully!");
        return "redirect:/service";
    }
}
