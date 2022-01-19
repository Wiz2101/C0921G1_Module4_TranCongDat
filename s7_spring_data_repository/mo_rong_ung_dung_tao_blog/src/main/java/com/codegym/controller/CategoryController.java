package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/category")
    public String showHomepage(Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Category> categoryList = categoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        return "/category/view";
    }

    @GetMapping("/category/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/category/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
        redirectAttributes.addFlashAttribute("createMsg", "Create or Update Successfully!");
        return "redirect:/category";
    }

    @GetMapping("/category/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Delete Successfully!");
        return "redirect:/category";
    }
}
