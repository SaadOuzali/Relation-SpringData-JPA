package com.example.relation.entitie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "utilisateur_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

//many to many without class d'association
//    @ManyToMany(mappedBy = "utilisateurs",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Collection<Group> groups = new ArrayList<>();


@JsonBackReference
    @OneToMany(mappedBy = "utilisateurs",cascade = CascadeType.ALL)
    private Collection<Inscription> inscriptions;


}
