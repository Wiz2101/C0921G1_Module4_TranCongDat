package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/product")
    public String showAll(Model model){
        List<Product> productList = productService.showAll();
        model.addAttribute("productList",productList);
        return "view";
    }

    @GetMapping("/product/create")
    public String showCreate(Model model){
        int max = 0;
        for (Product li:productService.showAll()){
            if (li.getId() > max){
                max = li.getId();
            }
        }
        int id = max + 1;
        Product product = new Product();
        product.setId(id);
        model.addAttribute("product",product);
        return "create";
    }

    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.create(product);
        redirectAttributes.addFlashAttribute("messageSC","Create " + product.getName() + " successfully!");
        return "redirect:/product";
    }

    @GetMapping("/product/update/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Product product = productService.select(id);
        model.addAttribute("product",product);
        return "edit";
    }

    @PostMapping("/product/update")
    public String edit(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("messageDE","Delete " + productService.select(id).getName() + " Successfully!" );
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/product/detail/{id}")
    public String viewDetail(@PathVariable int id, Model model){
        Product product = productService.select(id);
        model.addAttribute("product",product);
        return "detail";
    }

}
