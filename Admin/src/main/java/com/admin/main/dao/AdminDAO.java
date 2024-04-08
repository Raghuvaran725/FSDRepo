package com.admin.main.dao;

import java.util.List;

import com.admin.main.entity.Admin;


public interface AdminDAO {
	List<Admin> getAllAdmins();
	 
	Admin getAdminById(Long id);
 
	Admin createAdmin(Admin admin);
 
	Admin updateAdmin(Long id, Admin adminDetails);
 
    void deleteAdmin(Long id);
}
