package com.product.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.main.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
