package com.admin.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.main.dao.AdminDAO;
import com.admin.main.entity.Admin;
import com.admin.main.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO admindao;
	@Override
	public List<Admin> getAllAdmins() {
		
		return admindao.getAllAdmins();
	}

	@Override
	public Admin getAdminById(Long id) {
		// TODO Auto-generated method stub
		return admindao.getAdminById(id);
	}

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.createAdmin(admin);	
	}

	@Override
	public Admin updateAdmin(Long id, Admin adminDetails) {
		Admin admin = admindao.updateAdmin(id, adminDetails);
        if (admin != null) {
        	return admindao.updateAdmin(id,adminDetails);
        }
        return null;
	}

	@Override
	public void deleteAdmin(Long id) {
		admindao.deleteAdmin(id);
		
	}

}
