package ru.geekbrains.boot.springboothw4.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.boot.springboothw4.model.Product;
import ru.geekbrains.boot.springboothw4.services.ProductService;

import javax.servlet.http.HttpServletResponse;


// Чуть не смог доковырять html code))
@RequestMapping("/products")
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id, HttpServletResponse response) {
        productService.removeById(id);
        return "redirect:/products";
    }

    @PostMapping("/add")
    public String addStudent(@PathVariable Product product, HttpServletResponse response) {
        productService.add(product);
        return "redirect:/products";
    }
}
