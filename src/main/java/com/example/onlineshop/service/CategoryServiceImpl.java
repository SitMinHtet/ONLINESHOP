package com.example.onlineshop.service;

import com.example.onlineshop.domain.Category;
import com.example.onlineshop.repository.CategoryRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Data
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Id is not found"));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
