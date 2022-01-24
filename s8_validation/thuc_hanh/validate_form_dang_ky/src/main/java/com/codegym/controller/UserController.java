package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user")
    public ModelAndView findAll(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/view");
        modelAndView.addObject("userList",userService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/user/create")
    @Valid
    public String showCreate(Model model) {
        model.addAttribute(new UserDto());
        return "user/create";
    }

    @PostMapping("/user/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.saveOrUpdate(user);
        redirectAttributes.addFlashAttribute("SaveSC","Add or Update Successfully!");
        return "redirect:/user";
    }
}
