package com.admin.main.daoimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.main.dao.AdminDAO;
import com.admin.main.entity.Admin;
import com.admin.main.repository.AdminRepo;

@Repository
public class AdminDaoImpl implements AdminDAO{
	@Autowired
	private AdminRepo adminrepository;
	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> a= adminrepository.findAll();
		return a;
	}

	@Override
	public Admin getAdminById(Long id) {
		Optional<Admin> admin = adminrepository.findById(id); 
        return admin.orElse(null);	
	}

	@Override
	public Admin createAdmin(Admin admin) {
		Admin ad = adminrepository.save(admin);
		return ad;
	}

	@Override
	public Admin updateAdmin(Long id, Admin adminDetails) {
		Optional<Admin> existingAdmin = adminrepository.findById(id); // Check if the admin exists
        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();
            admin.setUsername(adminDetails.getUsername()); // Assuming you have username and password fields
            admin.setPassword(adminDetails.getPassword());
           
            return adminrepository.save(admin);
        }
        return null;
	}

	@Override
	public void deleteAdmin(Long id) {
		adminrepository.deleteById(id);
		
	}

}
