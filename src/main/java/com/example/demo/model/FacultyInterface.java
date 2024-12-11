package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Faculty;

public interface FacultyInterface extends JpaRepository<Faculty, String> {
	public Faculty findByusername(String username);
	public Faculty findByEmail(String username);
}
