package com.example.relation.dto;

import com.example.relation.entitie.Address;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Dtoo {
    private Long user_id;


    private String user_name;


    private String email;


    private String password;

//    private Address address;
}

