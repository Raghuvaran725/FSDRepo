package com.product.main.service;

import java.util.List;

import com.product.main.entity.Product;

public interface ProductService {
	public List<Product> getProducts();

	public Product getProduct(int pid);

	public Product addProduct(Product product);

	public String deleteProduct(int id);

	public Product updateProduct(Product product);
}
