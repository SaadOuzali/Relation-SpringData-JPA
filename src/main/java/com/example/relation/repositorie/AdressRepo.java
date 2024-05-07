package com.example.relation.repositorie;

import com.example.relation.entitie.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepo extends JpaRepository<Address,Long> {
//    long  deleteByUserId(Long id);
}
