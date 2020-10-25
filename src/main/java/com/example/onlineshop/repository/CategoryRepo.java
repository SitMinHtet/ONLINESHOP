package com.example.onlineshop.repository;

import com.example.onlineshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
