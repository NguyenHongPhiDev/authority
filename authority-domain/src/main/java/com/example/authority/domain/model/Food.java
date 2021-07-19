package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Food")
@Table(name ="food")
@Getter
@Setter
public class Food {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "AMOUNT")
    private Integer amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categorySet;
}
