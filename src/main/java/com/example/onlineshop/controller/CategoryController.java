package com.example.onlineshop.controller;

import com.example.onlineshop.domain.Category;
import com.example.onlineshop.service.CategoryService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("createCate",new Category());
        return "admin/categoryForm";
    }

    @PostMapping("/category")
    public String process(@Validated Category category, BindingResult result){

        if(result.hasErrors()){
            return "admin/categoryForm";
        }
        categoryService.create(category);
        return "redirect:/categoryShowForm";
    }

    @GetMapping("/categoryShowForm")
    public String showAllCategories(Model model){
        model.addAttribute("showCate",categoryService.finAll());

        return "admin/categoryShowForm";
    }
}
