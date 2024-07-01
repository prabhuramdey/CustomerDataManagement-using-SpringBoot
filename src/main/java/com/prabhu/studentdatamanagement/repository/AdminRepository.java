package com.prabhu.studentdatamanagement.repository;

import java.sql.Connection;

import com.prabhu.studentdatamanagement.dto.Admin;

public interface AdminRepository {

	Connection getConnection();
	
	String saveAdmin(Admin admin);
	
	Admin adminLogin(String adminName,String password);
}
