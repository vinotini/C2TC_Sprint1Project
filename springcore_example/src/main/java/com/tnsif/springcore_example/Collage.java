package com.tnsif.springcore_example;

import org.springframework.stereotype.Component;

@Component

public class Collage {
	private Student student;
	

	public void setStudent(Student student) {
		this.student = student;
	}

	public Collage() {
		
		System.out.println("Collage object is created..");
	}
	
	public void display() {
		System.out.println("MVIT");
		student.display();
	}
}