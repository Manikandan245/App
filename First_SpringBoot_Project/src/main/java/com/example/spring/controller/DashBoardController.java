package com.example.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class DashBoardController {
	@Autowired
    private StudentRepository studentRepository;

 //for showing all subjects
    @GetMapping("/dashboard/{username}")
    public ResponseEntity<?> getSubjects(@PathVariable String username) {
    	Optional<Student> user=studentRepository.findByUsername(username);
    		List<String> subjects = List.of("Tamil", "English", "Maths", "Science", "Social");
            return ResponseEntity.ok(Map.of("Welcome to DashBoard    ", username, "subjects  : ", subjects)); 
    }
}
