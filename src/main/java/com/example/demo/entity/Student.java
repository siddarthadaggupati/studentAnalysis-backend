package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    private int regno;
    private String name;
    private String email;
    private String password;
    private String department;

	@Column(name = "join_year")
    private int joinyear;

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }
    
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getJoinyear() {   
        return joinyear;
    }

    public void setJoinyear(int joinyear) {  
        this.joinyear = joinyear;
    }

	@Override
	public String toString() {
		return "Student [regno=" + regno + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", department=" + department + ", joinyear=" + joinyear + "]";
	}

    
}
