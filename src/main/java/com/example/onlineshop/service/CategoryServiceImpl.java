package com.example.onlineshop.service;

import com.example.onlineshop.domain.Category;
import com.example.onlineshop.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Data
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(id + " is not found"));
    }

    @Override
    public List<Category> finAll() {
        return categoryRepository.findAll();
    }
}
