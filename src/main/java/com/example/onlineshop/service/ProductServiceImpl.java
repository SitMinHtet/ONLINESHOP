package com.example.onlineshop.service;

import com.example.onlineshop.domain.Product;
import com.example.onlineshop.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService{
    private  final ProductRepository productRepository;


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    /*
    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
     */

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByCategoryId(int id) {
        return productRepository.findProductByCategoryId(id);
    }


}
