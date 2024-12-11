package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ResultsGPA {
	
	@Id
	private int regno;
	private double sgpa1;
	private double sgpa2;
	private double sgpa3;
	private double sgpa4;
	private double sgpa5;
	private double sgpa6;
	private double sgpa7;
	private double sgpa8;
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public double getSgpa1() {
		return sgpa1;
	}
	public void setSgpa1(double sgpa1) {
		this.sgpa1 = sgpa1;
	}
	public double getSgpa2() {
		return sgpa2;
	}
	public void setSgpa2(double sgpa2) {
		this.sgpa2 = sgpa2;
	}
	public double getSgpa3() {
		return sgpa3;
	}
	public void setSgpa3(double sgpa3) {
		this.sgpa3 = sgpa3;
	}
	public double getSgpa4() {
		return sgpa4;
	}
	public void setSgpa4(double sgpa4) {
		this.sgpa4 = sgpa4;
	}
	public double getSgpa5() {
		return sgpa5;
	}
	public void setSgpa5(double sgpa5) {
		this.sgpa5 = sgpa5;
	}
	public double getSgpa6() {
		return sgpa6;
	}
	public void setSgpa6(double sgpa6) {
		this.sgpa6 = sgpa6;
	}
	public double getSgpa7() {
		return sgpa7;
	}
	public void setSgpa7(double sgpa7) {
		this.sgpa7 = sgpa7;
	}
	public double getSgpa8() {
		return sgpa8;
	}
	public void setSgpa8(double sgpa8) {
		this.sgpa8 = sgpa8;
	}
	@Override
	public String toString() {
		return "ResultsGPA [regno=" + regno + ", sgpa1=" + sgpa1 + ", sgpa2=" + sgpa2 + ", sgpa3=" + sgpa3 + ", sgpa4="
				+ sgpa4 + ", sgpa5=" + sgpa5 + ", sgpa6=" + sgpa6 + ", sgpa7=" + sgpa7 + ", sgpa8=" + sgpa8 + "]";
	}
	
	
}
