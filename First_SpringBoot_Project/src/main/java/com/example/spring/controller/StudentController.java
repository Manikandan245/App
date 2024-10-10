package com.example.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;
import com.example.spring.service.StudentService;

@RestController
public class StudentController {
	 @Autowired
	    private StudentRepository studentRepository;
	    @Autowired
	    private StudentService studentService;
	   //signup Request
	    @PostMapping("/signup")
	    public ResponseEntity<?> signUp(@RequestBody Student user) {
	    	if(user.getUsername()!=null && user.getMobileNum()!=null)
	    	{
	        Student savedUser = studentRepository.save(user);
	        return ResponseEntity.ok(Map.of("message", "User registered successfully", "user", savedUser));
	    	}
	    	else
	    	{
	    		return ResponseEntity.ok(Map.of("invalid user details","Please submit valid user details"));	
	    	}
	    }
	    
	    //login Request
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
	        String username = loginRequest.get("username");
	        String defaultPwd = "1234";
	        if(username!=null && !username.isEmpty())
	        {
	        boolean isUserValid = studentService.isUsernameValid(username);

	        if (!isUserValid) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid username... Please try again Later."));
	        }
	        }
	        else
	    	{
	    		return ResponseEntity.ok(Map.of("invalid user details","Please submit valid user details"));	
	    	}
	        boolean isLoginSuccessful = false;
	        if(loginRequest.get("password").equals(defaultPwd))
	        {
	        	isLoginSuccessful=true;
	        }

	        if (isLoginSuccessful) {
	            return ResponseEntity.ok(Map.of("message", "Login successful... Welcome to the Application"));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials...Please Try Again Later.."));
	        }
	    }
}
