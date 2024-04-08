package com.product.main.daoimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.main.dao.ProductDao;
import com.product.main.entity.Product;
import com.product.main.repository.ProductRepo;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	ProductRepo productrepo;
	@Override
	public List<Product> getProducts() {
		List<Product> plist=productrepo.findAll(); 
		return plist;
	}

	@Override
	public Product getProduct(int pid) {
		Product product = productrepo.findById(pid).orElse(null);
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		Product p = productrepo.save(product);
		return p;
	}

	@Override
	public boolean deleteProduct(int pid) {
		Product p = productrepo.findById(pid).orElse(null);
		if (p == null) {
			return false;
		}
		productrepo.delete(p);
		return true;
	}

	@Override
	public Product updateProduct(Product product) {
		Product p = productrepo.save(product);
		return p;
	}

}
