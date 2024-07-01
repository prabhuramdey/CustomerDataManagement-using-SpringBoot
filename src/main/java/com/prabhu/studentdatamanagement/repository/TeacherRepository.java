package com.prabhu.studentdatamanagement.repository;

import java.sql.Connection;
import java.util.List;

import com.prabhu.studentdatamanagement.dto.Student;
import com.prabhu.studentdatamanagement.dto.Teacher;

public interface TeacherRepository {

	Connection getConnection();
	String saveTeacher(Teacher teacher);
	
	Teacher getTeacherById(int id);
	Teacher deleteTeacher(int id);
	Teacher updateTeacher(int id);
	
	
	List<Teacher> getTeacherBySubject(String sub);
	List<Teacher> getClassTeacher(String std);
	
	List<Teacher> getTeacherBySal(int sal);
	
	List<Teacher> getAllTeacher();
}
