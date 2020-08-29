package com.example.onlineshop.domain;


import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Cart {

    private Set<Product>  cartItems = new HashSet<>();


    public void addToCart(Product product){
        this.cartItems.add(product);
    }

    public void clearCart(Product product){
        this.cartItems.clear();
    }

    public Set<Product> getCartItems(){
        return this.cartItems;
    }

    public int cartSize(){
        if(cartItems.isEmpty()){
            return 0;
        }
        return this.cartItems.size();
    }
}
