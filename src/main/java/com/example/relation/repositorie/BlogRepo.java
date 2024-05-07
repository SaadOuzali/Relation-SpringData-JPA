package com.example.relation.repositorie;

import com.example.relation.entitie.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
