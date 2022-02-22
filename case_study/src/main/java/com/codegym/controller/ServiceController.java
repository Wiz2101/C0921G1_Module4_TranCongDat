package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.Service;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IServiceService;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String findAll(@RequestParam(defaultValue = "", value = "keyword") String keyword1, @RequestParam(defaultValue = "", value = "keyword") String keyword2,
                          @RequestParam(defaultValue = "") String rentTypeId,
                          @RequestParam(defaultValue = "") String serviceTypeId, Model model){
        List<Service> serviceList = serviceService.findAll();
        model.addAttribute("serviceList",serviceList);
        model.addAttribute("serviceTypeList",serviceTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        List<Service> services = serviceService.searchByNameAndSelect("%" + keyword1 + "%","%" + keyword2 + "%","%" + rentTypeId + "%","%" + serviceTypeId + "%");
        return "service/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("serviceTypeList",serviceTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService (@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new ServiceDto().validate(serviceDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("serviceTypeList",serviceTypeService.findAll());
            model.addAttribute("serviceDto",serviceDto);
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
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
