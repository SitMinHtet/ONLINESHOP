package com.example.onlineshop.controller;

import com.example.onlineshop.domain.Cart;
import com.example.onlineshop.domain.Product;
import com.example.onlineshop.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Data
public class CartController {

    private final Cart cart;
    private final ProductService productService;

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable int id, HttpServletRequest request){
        boolean existed = false;
        for (Product product:cart.getCartItem()){
            if (product.getId()==id){
                existed = true;
            }
        }
        if (!existed){
            cart.addToCart(productService.findById(id));
        }
        HttpSession session= request.getSession();
        session.setAttribute("cartsize", cart.cartSize());
        cart.addToCart(productService.findById(id));
        return "redirect:/detail/" + id;
    }

    @GetMapping("/cart/cartView")
    public String cartView(Model model){
        model.addAttribute("cartview", cart.getCartItem());
        return "user/cartView";
    }


}
