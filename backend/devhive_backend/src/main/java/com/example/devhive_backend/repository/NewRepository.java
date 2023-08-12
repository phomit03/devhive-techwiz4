package com.example.devhive_backend.repository;

import com.example.devhive_backend.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
    @Query("SELECT n FROM news n ORDER BY n.createdAt DESC")
    List<NewEntity> findTopNByOrderByCreatedAtDesc(@Param("count") int count);
}