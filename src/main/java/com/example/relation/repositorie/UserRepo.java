package com.example.relation.repositorie;

import com.example.relation.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
