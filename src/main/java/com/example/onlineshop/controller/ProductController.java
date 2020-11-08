package com.example.onlineshop.controller;

import com.example.onlineshop.domain.Category;
import com.example.onlineshop.domain.Product;
import com.example.onlineshop.service.CategoryService;
import com.example.onlineshop.service.ProductService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Data
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("createProduct")
    public String create(Model model){
        model.addAttribute("createPro", new Product());
        model.addAttribute("category", categoryService.findAll());
        return "admin/productForm";
    }

    @PostMapping("showProduct")
    public String process(Product product, BindingResult result,
                          Model model, RedirectAttributes attributes){

        logger.info("You Got That Product!!");

        if(result.hasErrors()){
            model.addAttribute("category", categoryService.findAll());
            return "admin/productForm";
        }
        productService.create(product);
        attributes.addFlashAttribute("success",true);
        return "redirect:/productShowForm";
    }

    @GetMapping("productShowForm")
    public String showAllProduct(Model model){
        model.addAttribute("allPro", productService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        return "admin/productShowForm";
    }

    @GetMapping("home/showProductByCate/{id}")
    public String showProductByCategoryId(@PathVariable int id, Model model){
        model.addAttribute("proByCate",productService.findProductByCategoryID(id));
        return "user/productByCategory";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model, HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session!=null){
            model.addAttribute("cartsize", session.getAttribute("cartsize"));
        }
        model.addAttribute("detail",productService.findById(id));
        return "user/detail";
    }
}