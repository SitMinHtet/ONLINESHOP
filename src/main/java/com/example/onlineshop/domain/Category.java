package com.example.onlineshop.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;


import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;

}
