package com.example.onlineshop.service;

import com.example.onlineshop.domain.Product;
import com.example.onlineshop.repository.ProductRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Id cannot found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findProductByCategoryID(int id) {
        return productRepo.findProductByCategoryId(id);
    }
}
