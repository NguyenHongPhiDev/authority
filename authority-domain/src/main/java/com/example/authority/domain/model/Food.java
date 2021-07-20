package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Food")
@Table(name ="food")
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "AMOUNT")
    private Integer amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categorySet;
}
