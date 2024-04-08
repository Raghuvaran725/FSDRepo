package com.product.main.dao;

import java.util.List;
import com.product.main.entity.Product;

public interface ProductDao {
	public List<Product> getProducts();

	public Product getProduct(int pid);

	public Product addProduct(Product product);

	public boolean deleteProduct(int pid);

	public Product updateProduct(Product product);
}
