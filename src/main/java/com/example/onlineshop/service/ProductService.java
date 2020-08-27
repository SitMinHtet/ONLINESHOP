package com.example.onlineshop.service;

import com.example.onlineshop.domain.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product findById(int id);
    //Product update(Product product);
    List<Product> findAll();
}
