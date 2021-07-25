package com.example.demo.repository;

import com.example.demo.models.SuperSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<SuperSet, Long> {
}
