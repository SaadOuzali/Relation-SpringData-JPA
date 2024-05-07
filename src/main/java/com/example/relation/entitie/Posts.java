package com.example.relation.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_Id")
   private Long postId;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id")
    private Customer customer;
}
