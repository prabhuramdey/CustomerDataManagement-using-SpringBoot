package com.prabhu.studentdatamanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prabhu.studentdatamanagement.dto.Student;
import com.prabhu.studentdatamanagement.util.AppConstants;
import com.prabhu.studentdatamanagement.util.ConnectionUtil;

public class StudentRepositoryImp implements StudentRepository{

//	@Override
//	public Connection getConnection() {
//		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			String url="jdbc:mysql://localhost:3306/school_data_management";
////			String user="root";
////			String password="root";
//			
//			Class.forName(AppConstants.DRIVERNAME);
//			String url=AppConstants.DB_URL;
//			String user=AppConstants.DB_USERNAME;
//			String password=AppConstants.DB_PASSWORD;
//			
//			return DriverManager.getConnection(url,user,password);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	@Override
	public Student studentLogin(String email, String password) {
		//Student student=new Student();
		Connection connection=ConnectionUtil.getConnection();
		Student student=null;
		String query="SELECT * FROM student WHERE email=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				student = new Student();
				 student.setId(resultSet.getInt(1));
				 student.setName(resultSet.getString(2));
				 student.setEmail(resultSet.getString(3));
				 student.setStd(resultSet.getString(4));
				 student.setSec(resultSet.getString(5));
				 student.setOverAllPercentage(resultSet.getString(6));
				 student.setGender(resultSet.getString(7));
				 student.setParentContact(resultSet.getString(8));
				 student.setRemarks(resultSet.getString(9));
				 student.setAddress(resultSet.getString(10));
				 student.setPassword(resultSet.getString(11));			 
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String saveStudent(Student student) {		
		Connection connection=ConnectionUtil.getConnection();
		String query="INSERT INTO student(name, email, std, sec, over_all_percentage, gender, parent_contact, remarks, address, password)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getStd());
			ps.setString(4, student.getSec());
			ps.setString(5, student.getOverAllPercentage());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getParentContact());
			ps.setString(8, student.getRemarks());
			ps.setString(9, student.getAddress());
			ps.setString(10, student.getPassword());
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
	public Student getStudentById(int id) {
         
		Connection connection=ConnectionUtil.getConnection();
		String query="SELECT * FROM student WHERE id=?";
		Student student=new Student();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				 student.setId(resultSet.getInt(1));
				 student.setName(resultSet.getString(2));
				 student.setEmail(resultSet.getString(3));
				 student.setStd(resultSet.getString(4));
				 student.setSec(resultSet.getString(5));
				 student.setOverAllPercentage(resultSet.getString(6));
				 student.setGender(resultSet.getString(7));
				 student.setParentContact(resultSet.getString(8));
				 student.setRemarks(resultSet.getString(9));
				 student.setAddress(resultSet.getString(10));
				 student.setPassword(resultSet.getString(11));	
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
        Connection connection = ConnectionUtil.getConnection();
        String query="delete from student where id=?";
        Student student=getStudentById(id);
        
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
        
		return student;
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
