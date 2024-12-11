package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ResultsGPA;

public interface ResultGPAInterface extends JpaRepository<ResultsGPA, Integer> {
	
	public ResultsGPA findByRegno(int regno);
}
