package com.prabhu.studentdatamanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prabhu.studentdatamanagement.dto.Admin;

public class AdminRepositoryImp implements AdminRepository{

	@Override
	public Connection getConnection() {

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school_data_management";
		String user="root";
		String password="root";
           
		return DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return null;
	}

	@Override
	public String saveAdmin(Admin admin) {

		Connection connection = getConnection();
		String query="INSERT INTO admin(admin_name, password)"
				+ "VALUES(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getPassword());
			
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
	public Admin adminLogin(String adminName, String password) {

		Admin admin=new Admin();
		Connection connection = getConnection();
		String query="SELECT * FROM admin WHERE adminName=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, adminName);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			if(resultSet.next()) {
				
				 admin.setAdminName(resultSet.getString(1));
				 admin.setPassword(resultSet.getString(2));	 			 
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

}
