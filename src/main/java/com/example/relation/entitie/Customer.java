package com.example.relation.entitie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customerr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private Long CustomerId;

    @Column(name = "customer_Name")
    private String customerName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Posts> posts;


}
