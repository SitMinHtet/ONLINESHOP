package com.example.onlineshop.controller;


import com.example.onlineshop.domain.Cart;
import com.example.onlineshop.domain.Product;
import com.example.onlineshop.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@Data
public class CartController {

    private final Cart cart;
    private final ProductService productService;

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable int id, HttpServletRequest request){

        boolean isExisted = false;
        for (Product product:cart.getCartItems()){
            if (product.getId()==id){
                isExisted=true;
            }
        }
        if(!isExisted){
            cart.addToCart(productService.findById(id));
        }

         HttpSession session= request.getSession();
         session.setAttribute("cartSize",cart.cartSize());
         return "redirect:/product/}" + id;
    }
}
