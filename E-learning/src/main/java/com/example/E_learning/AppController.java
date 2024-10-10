package com.example.E_learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("/hello")
public String hello()
{
	return "welcome to My Application";
}
}
