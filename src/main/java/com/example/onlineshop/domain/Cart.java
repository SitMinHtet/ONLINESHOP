package com.example.onlineshop.domain;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Cart {

    public Set<Product> cartItems = new HashSet<>();

    public void addToCart(Product product){
        this.cartItems.add(product);
    }

    public void  clearCart(){
        this.cartItems.clear();
    }

    public Set<Product> getCartItem(){
        return this.cartItems;
    }

    public int cartSize(){
        if(cartItems.isEmpty()){
            return 0;
        }
        return  this.cartItems.size();
    }
}
