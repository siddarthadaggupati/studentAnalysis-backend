package com.example.demo.model;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.example.demo.entity.Student;

@Component
public class StudentDAO {
	
	@Autowired
	StudentInterface srepo;
	
	public List<Student> getAll(){
		return srepo.findAll();
	}
	
	public String insertStudent(Student student) {
		try {
			System.out.println("from dao class: "+student);
			srepo.save(student);
			return "student added";
		}
		catch(Exception e) {
			return "Student not added";
		}
	}
	
	public Student findStudent(int regno) {
		try {
			return srepo.findByregno(regno);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public String deleteStudent(int regno) {
		try {
			Student s = findStudent(regno);
			srepo.delete(s);
			return "Student Deleted";
		}
		catch(Exception e) {
			return "Student Not Deleted";
		}
	}
	
	public String updateStudent(Student student) {
		Student s = findStudent(student.getRegno());
		try {
			srepo.delete(s);
			srepo.save(student);
			return "Student Updated Successfully";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Map<String, Object>> StudentCountByDepartment(){
		return srepo.findStudentCountByDepartment();
	}
	
	
	public String saveStudentsFromCsv(MultipartFile file) {
	    List<Student> students = new ArrayList<>();
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	        String line;

	        // Skip header if present
	        boolean skipHeader = true;

	        while ((line = br.readLine()) != null) {
	            if (skipHeader) {
	                skipHeader = false;
	                continue;
	            }
	            String[] data = line.split(",");
	            Student student = new Student();
	            student.setRegno(Integer.parseInt(data[0].trim()));
	            student.setName(data[1].trim());
	            student.setEmail(data[2].trim());
	            student.setPassword(data[3].trim());
	            student.setDepartment(data[4].trim());
	            student.setJoinyear(Integer.parseInt(data[5].trim()));
	            students.add(student);
	        }
	        srepo.saveAll(students);
	        return "Uploaded successfully";
	    } catch (IOException e) {
	        e.printStackTrace(); // Log the error for debugging
	        return "Failed to upload: " + e.getMessage();
	    }
	}

}
