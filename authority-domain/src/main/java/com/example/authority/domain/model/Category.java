package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name ="Category")
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "categoryName")
    private String categoryName;
    @OneToMany()
    private Set<Food> foodSet;
}
