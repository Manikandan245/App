package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	 Optional<Question> findByIdAndSubject(Long id, String subject);
}
