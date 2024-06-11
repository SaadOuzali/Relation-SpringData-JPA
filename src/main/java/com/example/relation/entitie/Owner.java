package com.example.relation.entitie;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "OWNER_DETAIL")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

//    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Blog> blogList;


//    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_Id")
    private Address address;

    public Owner() { }

    public Owner(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Address getAddress(){
        return this.address;
    }
    public void setAddress(Address address){
        this.address=address;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Blog> getBlogList() { return blogList; }
    public void setBlogList(List<Blog> blogList) { this.blogList = blogList; }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}