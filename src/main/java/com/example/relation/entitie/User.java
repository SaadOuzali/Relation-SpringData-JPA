package com.example.relation.entitie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;










    //  version 5dama dial one to one
//    @JsonManagedReference
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id" )
//    private Address address;












//    @JsonManagedReference
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
//    private Address address;




}

