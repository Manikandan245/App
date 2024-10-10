package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepository; 

    
    public boolean isUsernameValid(String username) {
        return studentRepository.existsByUsername(username);
    }
}
