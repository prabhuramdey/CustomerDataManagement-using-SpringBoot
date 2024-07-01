package com.prabhu.studentdatamanagement.service;

import java.util.List;

import com.prabhu.studentdatamanagement.dto.Student;
import com.prabhu.studentdatamanagement.repository.StudentRepository;
import com.prabhu.studentdatamanagement.repository.StudentRepositoryImp;
import com.prabhu.studentdatamanagement.util.AES;
import com.prabhu.studentdatamanagement.util.AppConstants;

public class StudentServiceImp implements StudentService{

	StudentRepository repository;
	{
		repository=new StudentRepositoryImp();
	}
	@Override
	public Student studentLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveStudent(Student student) {

		String encEmail=AES.encrypt(student.getEmail(), AppConstants.SECRETEKEY);
		String encAddress=AES.encrypt(student.getAddress(), AppConstants.SECRETEKEY);
		String encParentContact=AES.encrypt(student.getParentContact(), AppConstants.SECRETEKEY);
		String encPassword=AES.encrypt(student.getPassword(), AppConstants.SECRETEKEY);
		student.setEmail(encEmail);
		student.setAddress(encAddress);
		student.setParentContact(encParentContact);
		student.setPassword(encPassword);
		
		return repository.saveStudent(student);
	}

	@Override
	public Student getStudentById(int id) {

		Student student=repository.getStudentById(id);
		String decEmail=AES.encrypt(student.getEmail(), AppConstants.SECRETEKEY);
		String decAddress=AES.encrypt(student.getAddress(), AppConstants.SECRETEKEY);
		String decParentContact=AES.encrypt(student.getParentContact(), AppConstants.SECRETEKEY);
		String decPassword=AES.encrypt(student.getPassword(), AppConstants.SECRETEKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByStd(String std) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByStdAndSec(String std, String sec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String lower, String high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
