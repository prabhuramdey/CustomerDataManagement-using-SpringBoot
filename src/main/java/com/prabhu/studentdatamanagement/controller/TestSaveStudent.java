package com.prabhu.studentdatamanagement.controller;

import com.prabhu.studentdatamanagement.dto.Student;
import com.prabhu.studentdatamanagement.service.StudentService;
import com.prabhu.studentdatamanagement.service.StudentServiceImp;

public class TestSaveStudent {
	public static void main(String[] args) {
		StudentService service=new StudentServiceImp();
		
		Student student=new Student();
		student.setName("Rahul");
		student.setEmail("rahul@gmail.com");
		student.setGender("male");
		student.setOverAllPercentage("98.55");
		student.setParentContact("9789658745");
		student.setSec("A");
		student.setStd("XII");
		student.setRemarks("Expert at logical");
		student.setAddress(" Marathalli");
		student.setPassword("1234");
		service.saveStudent(student);
		//System.out.println(service.getStudentById(1));
	}

}
