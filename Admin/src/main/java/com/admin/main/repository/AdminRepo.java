package com.admin.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.main.entity.Admin;

public interface AdminRepo  extends JpaRepository<Admin, Long>{

}
