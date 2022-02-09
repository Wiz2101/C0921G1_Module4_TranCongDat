package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model, Pageable pageable) {
        model.addAttribute("productList", productService.findAll(pageable));
        return "shop/view";
    }

    @GetMapping(path = {"/cart/add/{id}", "/product/detail/cart/add/{id}"})
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "shop/error404";
        }
        if (action.equals("increase")) {
            cart.addToCart(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("decrease")) {
            cart.decreaseFromCart(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addToCart(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("product/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "shop/detail";
        } else {
            return "shop/error404";
        }
    }

    @GetMapping("cart/remove/{id}")
    public String removeProduct(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.removeFromCart(productOptional.get());
            return "redirect:/shopping-cart";
        } else {
            return "shop/error404";
        }

    }
}
