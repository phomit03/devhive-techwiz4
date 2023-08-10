package com.example.devhive_backend.payload.payload.repository;

import java.util.Optional;

import com.example.devhive_backend.entity.ERole;
import com.example.devhive_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
