package com.example.project.repository;

import com.example.project.domain.Orderm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orderm, Integer> {    
}