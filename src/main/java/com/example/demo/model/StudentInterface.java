package com.example.demo.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentInterface extends JpaRepository<Student, Integer> {
	public Student findByregno(int regno);
	
	@Query("SELECT s.department AS department, COUNT(s) AS count FROM Student s GROUP BY s.department")
	public List<Map<String, Object>> findStudentCountByDepartment();
}
