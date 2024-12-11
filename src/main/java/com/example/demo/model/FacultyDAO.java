package com.example.demo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Faculty;

@Component
public class FacultyDAO {
	
	@Autowired
	FacultyInterface frepo;
	
	public String insertFaculty(Faculty f) {
		try {
			return frepo.save(f).toString();
		}
		catch(Exception e) {
			return "faculty not added";
		}
	}
	
	public boolean verifyLogin(String username, String password) {
		Faculty user = frepo.findByusername(username);
		if(user.getPassword().equals(password)) return true;
		
		return false;
	}
	public String updatePassword(String email, String password) {
		try {
			Faculty f = frepo.findByEmail(email);
			frepo.delete(frepo.findByEmail(email));
			f.setPassword(password);
			frepo.save(f);
			return "Password Updated Successfully";
		}
		catch(Exception e) {
			return "Internal Error";
		}
	}
	
}
