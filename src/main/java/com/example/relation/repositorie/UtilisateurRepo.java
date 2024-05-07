package com.example.relation.repositorie;

import com.example.relation.entitie.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateurs,Long> {
    Utilisateurs findByUserName(String username);
}
