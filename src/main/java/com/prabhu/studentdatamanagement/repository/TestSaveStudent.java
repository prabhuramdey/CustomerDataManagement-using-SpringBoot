package com.prabhu.studentdatamanagement.repository;

import com.prabhu.studentdatamanagement.dto.Student;

public class TestSaveStudent {

	public static void main(String[] args) {
		
//		Student student=new Student();
//		student.setName("Barsha");
//		student.setEmail("barsha@gmail.com");
//		student.setStd("14");
//		student.setSec("A");
//		student.setOverAllPercentage("78.90");
//		student.setGender("female");
//      student.setParentContact("6379013498");	
//		student.setRemarks("Exceptionally Good");
//		student.setAddress("Cuttack");
//		student.setPassword("12345");
//		
    	StudentRepository repository = new StudentRepositoryImp();
//		System.out.println(repository.saveStudent(student));
		
//		Student student=repository.studentLogin("prabhuramdey2000@gmail.com", "1790");
//		if(student != null) {
//			System.out.println(student.getName());
//		}else {
//			System.out.println("invalid user and password");
//		}
    	repository.deleteStudent(4);
	}
}
