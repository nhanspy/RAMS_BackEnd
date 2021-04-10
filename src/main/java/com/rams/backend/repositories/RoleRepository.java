package com.rams.backend.repositories;

import com.rams.backend.entities.role_user.ERole;
import com.rams.backend.entities.role_user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}