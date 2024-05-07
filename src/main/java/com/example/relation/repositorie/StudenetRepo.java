package com.example.relation.repositorie;

import com.example.relation.entitie.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenetRepo extends JpaRepository<Student,Long> {
}
