package com.admin.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.main.entity.Admin;
import com.admin.main.exception.AdminNotFoundException;
import com.admin.main.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	  private  AdminServiceImpl adminService; 
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
//    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
//        Admin admin = adminService.getAdminById(id);
//        if (admin != null) {
//            return new ResponseEntity<>(admin, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") int id) {
        Admin admin = adminService.getAdminById((long) id);
        if (admin == null) {
            throw new AdminNotFoundException("Admin not found with id: " + id);
        }
        return ResponseEntity.ok(admin);
    }
 
    @PostMapping("/add")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {    	
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
        if (updatedAdmin != null) {
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@RequestParam Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
