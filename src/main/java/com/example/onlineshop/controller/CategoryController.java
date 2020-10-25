package com.example.onlineshop.controller;

import com.example.onlineshop.domain.Category;
import com.example.onlineshop.service.CategoryService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Data
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("createCategory")
    public String create(Model model){
        model.addAttribute("createCate", new Category());
        return "admin/categoryForm";
    }

    @PostMapping("showCategory")
    public String process(@Valid Category category, Model model, BindingResult result){
        if(result.hasErrors()){
            return "admin/categoryForm";
        }
        categoryService.create(category);
        return "redirect:/categoryShowForm";
    }

    @GetMapping("categoryShowForm")
    public String showAllCategory(Model model){
        model.addAttribute("allCate", categoryService.findAll());
        return "admin/categoryShowForm";
    }

}
