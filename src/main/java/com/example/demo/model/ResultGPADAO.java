package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ResultsGPA;

@Component
public class ResultGPADAO {
	
	@Autowired
	ResultGPAInterface grepo;
	
	public String addRecord(ResultsGPA res) {
		
		try {
			grepo.save(res);
			//System.out.println(res);
			return "Result Saved";
		}
		catch(Exception e) {
			return "Result not Saved";
		}
	}
	
	public ResultsGPA findCGPA(int regno) {
		System.out.println(grepo.findByRegno(regno));
		return grepo.findByRegno(regno);
	}
}
