package com.example.relation.repositorie;

import com.example.relation.entitie.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group,Long> {
    Group findByGroupName(String groupname);
}
