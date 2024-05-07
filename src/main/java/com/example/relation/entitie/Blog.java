package com.example.relation.entitie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "BLOG_DETAIL")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Blog() { }

    public Blog(String title, String category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title='" + title + '\'' + ", category='" + category + '\'' +
                ", content='" + content + '\'' + '}';
    }
}
