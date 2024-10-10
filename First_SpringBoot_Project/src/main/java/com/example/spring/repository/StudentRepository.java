package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	Optional<Student> findByUsername(String username);
    boolean existsByUsername(String username);
}
