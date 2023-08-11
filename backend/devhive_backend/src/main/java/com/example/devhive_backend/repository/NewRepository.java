package com.example.devhive_backend.repository;

import com.example.devhive_backend.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<New, Long> {
}
