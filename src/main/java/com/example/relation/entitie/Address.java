package com.example.relation.entitie;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_Id")
    private  Long addressId;


    //tab3a lbu ghazala
//    @Column(name = "user_Id")
//    private Long userId;


    @Column(name = "streetname")
    private String streetName;

    @Column(name = "address")
    private String address;


   @JsonBackReference
    @OneToOne(mappedBy = "address")
    private User user;

//    @JsonBackReference(value = "adressOwner")
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Owner owner;



















////whadi dakchi li t3almto mn youtube wbest practice dial one to one
//    @JsonBackReference
//    @OneToOne(mappedBy = "address",cascade = CascadeType.REMOVE)
//    private User user;







    //hadi hiya l methode dial abughazala

//    @JsonBackReference
//    @OneToOne()
//    @JoinColumn(name = "user_Id",insertable = false,updatable = false)
//    private User user;


}

