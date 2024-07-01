package com.prabhu.studentdatamanagement.repository;

import com.prabhu.studentdatamanagement.dto.Admin;

public class TestSaveAdmin {

	public static void main(String[] args) {
		
//		Admin admin=new Admin();
//		admin.setAdminName("Prabhu");
//		admin.setPassword("1234");
		
		AdminRepository repository = new AdminRepositoryImp();
		//System.out.println(admin1.saveAdmin(admin));
		Admin admin=repository.adminLogin("prabhuramdey2000@gmail.com", "1790");
		if(admin != null) {
			System.out.println(admin.getAdminName());
		}else {
			System.out.println("invalid user and password");
		}
	}
}
