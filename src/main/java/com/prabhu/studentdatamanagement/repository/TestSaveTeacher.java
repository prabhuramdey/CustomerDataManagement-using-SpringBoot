package com.prabhu.studentdatamanagement.repository;

import com.prabhu.studentdatamanagement.dto.Teacher;

public class TestSaveTeacher {
	public static void main(String[] args) {
		
//		Teacher teacher=new Teacher();
//		teacher.setName("Hari");
//		teacher.setEmail("hari@gmail.com");
//		teacher.setContact("785322898");
//		teacher.setSubject("ENGLISH");
//		teacher.setClassTeacher("C");
//		teacher.setSal(27589);
//		teacher.setAddress("Cuttack");
//		teacher.setPassword("1234");
     
		
    	TeacherRepository respirotory = new TeacherRepositoryImp();
    	//System.out.println(respirotory.saveTeacher(teacher));
    	//System.out.println(respirotory.getTeacherById(1));
    	System.out.println(respirotory.deleteTeacher(4));
	}

}
