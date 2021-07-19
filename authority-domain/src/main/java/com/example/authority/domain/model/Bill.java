package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Bill")
@Table(name = "BILL")
@Getter
@Setter
public class Bill {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToMany()
    public Set<Bill_Info> bill_info;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    public User userSet;
}
