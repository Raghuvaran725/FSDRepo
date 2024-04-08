package com.product.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.main.dao.ProductDao;
import com.product.main.entity.Product;
import com.product.main.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productdao;
	@Override
	public List<Product> getProducts() {
		List<Product> productList = productdao.getProducts();
		return productList;
	}

	@Override
	public Product getProduct(int pid) {
		Product product = productdao.getProduct(pid);
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		Product p = productdao.addProduct(product);
		return p;
	}

	@Override
	public String deleteProduct(int pid) {
		productdao.deleteProduct(pid);
		return "Deleted Product Succesfully";
	}

	@Override
	public Product updateProduct(Product product) {
		Product p = productdao.updateProduct(product);
		return p;
	}

}
