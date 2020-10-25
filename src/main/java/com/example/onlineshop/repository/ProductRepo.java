package com.example.onlineshop.repository;

import com.example.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByCategory_Id(int id);

    @Query("select p from Product p where p.category.id=:id ")
    List<Product> findProductByCategoryId(@Param("id") int id);
}
