package com.example.onlineshop.controller;

import com.example.onlineshop.domain.Product;
import com.example.onlineshop.service.CategoryService;
import com.example.onlineshop.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Data
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/createProduct")
    public String create(Model model){
        model.addAttribute("createPro",new Product());
        model.addAttribute("existcate",categoryService.finAll());
        return "admin/productForm";
    }

    @PostMapping("/product")
    public String process(@Validated Product product, BindingResult result, Model model,
                          RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            model.addAttribute("existcate",categoryService.finAll());
            return "admin/productForm";
        }
        productService.create(product);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/productShowForm";
    }

    @GetMapping("/productShowForm")
    public String showProduct(Model model){
        model.addAttribute("showPro",productService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        return "admin/productShowForm";
    }
}
