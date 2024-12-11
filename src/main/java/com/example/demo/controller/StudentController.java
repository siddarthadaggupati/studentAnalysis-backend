package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDAO;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentDAO sdao;
	
	@GetMapping("/getallstudents")
	public List<Student> fun1(){
		return sdao.getAll();
	}
	
	@PostMapping("/insertstudent")
	public String fun2(@RequestBody Student student) {
		System.out.println(student);
		return sdao.insertStudent(student);
		
	}
	
	@PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty!");
        }
        sdao.saveStudentsFromCsv(file);
        return ResponseEntity.ok("Students added successfully!");
    }
	
	@DeleteMapping("/deletestudent")
	public String fun3(@RequestParam("regno") int regno) {
		return sdao.deleteStudent(regno);
	}
	
	@PutMapping("/updatestudent")
	public String fun4(@RequestBody Student student) {
		System.out.println(student);
		return sdao.updateStudent(student);
	}
	
	@GetMapping("/tdash")
	public List<Map<String,Object>> fun5() {
		List<Map<String,Object>>res = sdao.StudentCountByDepartment();
		return res;
	}
	
	@PostMapping("/loginstudent")
	public String fun6(@RequestBody Student s) {
		try {
			Student res = sdao.findStudent(s.getRegno());
			if(res != null) {
				if(res.getPassword().equals(s.getPassword())) {
					return "login succesful";
				}
				return "incorrect username or password";
			}
			return "incorrect username or password";
		}
		catch(Exception e) {
			return "incorrect username or password";
		}
	}
	
}
