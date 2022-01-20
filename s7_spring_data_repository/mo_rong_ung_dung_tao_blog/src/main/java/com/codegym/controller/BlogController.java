package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public String showHomepage(Optional<String> keyword, Optional<Long> category, Model model, @PageableDefault(size = 5, sort = "createDate", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("categoryList", categoryService.findAll());
        if (!keyword.isPresent() || keyword.get().equals("")) {
            if (!category.isPresent()) {
                model.addAttribute("blogList", blogService.findAll(pageable));
            } else {
                model.addAttribute("blogList", categoryService.searchById(category.get(), pageable));
                model.addAttribute("category", category.get());
            }
        } else if (!category.isPresent()) {
            model.addAttribute("keyword", keyword.get());
            model.addAttribute("blogList", blogService.findAllByAuthorContaining(keyword.get(), pageable));
        } else {
            model.addAttribute("blogList", blogService.searchByAuthorAndType(keyword.get(), category.get(), pageable));
        }
        return "/blog/view";
    }

    @GetMapping("/blog/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveOrUpdate(blog);
        redirectAttributes.addFlashAttribute("createMsg", "Create or Update Successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Delete Successfully!");
        return "redirect:/blog";
    }

//    @GetMapping("blog/search")
//    public String search(@RequestParam String keyword, @RequestParam Long category, Model model, Pageable pageable){
//        Page<Blog> blogList = blogService.searchByAuthorAndType(keyword,category,pageable);
//        model.addAttribute("blogList",blogList);
//        return "blog/view";
//    }
}
