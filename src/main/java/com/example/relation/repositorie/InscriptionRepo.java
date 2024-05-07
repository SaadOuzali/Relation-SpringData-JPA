package com.example.relation.repositorie;

import com.example.relation.entitie.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepo extends JpaRepository<Inscription,Long> {
}
