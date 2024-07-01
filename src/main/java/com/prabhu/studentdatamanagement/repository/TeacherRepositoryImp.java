package com.prabhu.studentdatamanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prabhu.studentdatamanagement.dto.Student;
import com.prabhu.studentdatamanagement.dto.Teacher;

public class TeacherRepositoryImp implements TeacherRepository {

	@Override
	public Connection getConnection() {
          try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school_data_management";
			String user="root";
			String password="root";
			
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveTeacher(Teacher teacher) {
      
		//Teacher tech=new Teacher();
		Connection connection = getConnection();
		String query="INSERT INTO teacher(name, email, contact, subject, class_teacher, sal, address, password)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getEmail());
			ps.setString(3, teacher.getContact());
			ps.setString(4, teacher.getSubject());
			ps.setString(5, teacher.getClassTeacher());
			ps.setInt(6, teacher.getSal());
			ps.setString(7, teacher.getAddress());
			ps.setString(8, teacher.getPassword());
			
			int res=ps.executeUpdate();
			connection.close();
			return res+"row of data added sucessfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Teacher getTeacherById(int id) {

		Connection connection=getConnection();
		String query="SELECT * FROM teacher WHERE id=?";
		Teacher teacher=new Teacher();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next()) {
				teacher.setId(resultSet.getInt(1));
				teacher.setName(resultSet.getString(2));
				teacher.setEmail(resultSet.getString(3));
				teacher.setContact(resultSet.getString(4));
				teacher.setSubject(resultSet.getString(5));
				teacher.setClassTeacher(resultSet.getString(6));
				teacher.setSal(resultSet.getInt(7));
				teacher.setAddress(resultSet.getString(8));
				teacher.setPassword(resultSet.getString(9));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public Teacher deleteTeacher(int id) {

		Connection connection = getConnection();
		String query="delete from teacher where id=?";
		Teacher teacher = getTeacherById(id);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			System.out.println(res+" no. of data deleted");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Teacher updateTeacher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getClassTeacher(String std) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySal(int sal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

}
