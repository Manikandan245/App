package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Score;

public interface ScoreRepository extends JpaRepository<Score, String> {
}
