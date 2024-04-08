package com.admin.main.service;

import java.util.List;

import com.admin.main.entity.Admin;

public interface AdminService {
	List<Admin> getAllAdmins();
	 
    Admin getAdminById(Long id);
 
    Admin createAdmin(Admin admin);
 
    Admin updateAdmin(Long id, Admin adminDetails);
 
    void deleteAdmin(Long id);
}
