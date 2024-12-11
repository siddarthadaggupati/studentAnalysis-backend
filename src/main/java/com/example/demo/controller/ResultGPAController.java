package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResultsGPA;
import com.example.demo.model.ResultGPADAO;

@RestController
@CrossOrigin
public class ResultGPAController {
	
	@Autowired
	ResultGPADAO rdao;
	
	@PostMapping("/addgpa")
	public String fun1(@RequestBody ResultsGPA result) {
		return rdao.addRecord(result);
	}
	
	@GetMapping("/getcgpa")
	public List<Map<String, Object>> fun2(@RequestParam("regno") int regno) {
		ResultsGPA result = rdao.findCGPA(regno);
		
	    if (result == null) {
	    	//System.out.println("null is found the value");
	        return null;
	    }

	    List<Map<String, Object>> formattedGPA = new ArrayList<>();

	    double[] sgpas = {
	        result.getSgpa1(), result.getSgpa2(), result.getSgpa3(), 
	        result.getSgpa4(), result.getSgpa5(), result.getSgpa6(), 
	        result.getSgpa7(), result.getSgpa8()
	    };

	    for (int i = 0; i < sgpas.length; i++) {
	        Map<String, Object> entry = new HashMap<>();
	        entry.put("sem", "sgpa" + (i + 1));
	        entry.put("cgpa", sgpas[i]);
	        formattedGPA.add(entry);
	    }
	    return formattedGPA;
	}
}
