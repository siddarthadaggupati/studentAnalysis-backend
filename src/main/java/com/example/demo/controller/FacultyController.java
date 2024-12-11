package com.example.demo.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Faculty;
import com.example.demo.model.FacultyDAO;


@RestController
@CrossOrigin
public class FacultyController {
	
	@Autowired
	FacultyDAO fdao;
	
	@Autowired
	EmailController em;
	
	@GetMapping("/")
	public String fun1() {
		return "Welcome siddartha";
	}
	
	@PostMapping("/addfaculty")
	public String insert(@RequestBody Faculty f) {
		return "Data Inserted "+fdao.insertFaculty(f);
	}
	
	@PostMapping("/loginfaculty")
	public String fun4(@RequestBody Map<String, String> requestBody) {
	    String username = requestBody.get("username");
	    String password = requestBody.get("password");
	    
		System.out.println("welcome "+username);
		return fdao.verifyLogin(username, password)?"login succesful" : "no user found";
	}
	
	@PostMapping("/updatepassword")
	public String fun5(@RequestBody Map<String, String> requestBody) {
		String email = requestBody.get("email");
		String pas = requestBody.get("password");
		return fdao.updatePassword(email, pas);
	}
}
