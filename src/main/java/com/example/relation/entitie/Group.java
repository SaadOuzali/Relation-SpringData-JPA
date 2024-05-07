package com.example.relation.entitie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Group_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

//many to many without class d'association
//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Groups_Users",
//            joinColumns = { @JoinColumn(name = "group_id") },
//            inverseJoinColumns = { @JoinColumn(name = "user_id") }
//    )
//    Collection<Utilisateurs> utilisateurs = new ArrayList<>();


    //many to many with class d'association

    @JsonBackReference
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private Collection<Inscription> inscriptions;


}
