package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/blog")
    public String showHomepage(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/view";
    }

    @GetMapping("/blog/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveOrUpdate(blog);
        redirectAttributes.addFlashAttribute("createMsg","Create or Update Successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit";
    }

    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("deleteMsg","Delete Successfully!");
        return "redirect:/blog";
    }
}
