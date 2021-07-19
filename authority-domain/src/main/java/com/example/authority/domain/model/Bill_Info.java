package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "bill_info")
@Table(name = "bill_info")
@Setter
@Getter
public class Bill_Info {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name ="count")
    private Integer count;

    @OneToMany
    private Set<Food> foodSet;
}
