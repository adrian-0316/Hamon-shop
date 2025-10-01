package com.example.jamonshop.controller;

import com.example.jamonshop.entity.Product;
import com.example.jamonshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("newProduct", new Product()); // для формы добавления
        return "index";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }
}
