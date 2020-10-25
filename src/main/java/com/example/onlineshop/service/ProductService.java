package com.example.onlineshop.service;

import com.example.onlineshop.domain.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product findById(int id);
    List<Product> findAll();
    //List<Product> findByCategoryId(int id);
    List<Product> findProductByCategoryID(int id);
}
