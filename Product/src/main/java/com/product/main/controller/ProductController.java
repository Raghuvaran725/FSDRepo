package com.product.main.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.main.entity.Product;
import com.product.main.service.ProductService;

@RestController
@RequestMapping(name="/product")
public class ProductController {
	@Autowired
	ProductService productservice;

	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = productservice.getProducts();

		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	@GetMapping("/product{id}")
	public ResponseEntity<Product> getProduct(@RequestParam("/pid") int pid) {
		Product product = productservice.getProduct(pid);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product p = productservice.addProduct(product);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@RequestParam int id) {
		productservice.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product p = productservice.updateProduct(product);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
}
