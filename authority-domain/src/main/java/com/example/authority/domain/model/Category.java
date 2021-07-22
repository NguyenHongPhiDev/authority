package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name ="Category")
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Integer id;
    @Column(name = "categoryName")
    private String categoryName;
}
