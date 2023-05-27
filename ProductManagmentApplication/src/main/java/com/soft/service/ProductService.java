package com.soft.service;

import java.util.HashMap;
import java.util.List;

import com.soft.model.Product;

public interface ProductService {
	
	public HashMap<String, Object> addNewProdcutService(Product product);
	
	public List<Product> getAllProduct();
	
	public HashMap<String, Object> deleteProductById(int pid);
	
	public HashMap<String, Object> updateProductById(Product product, int pid);
	
	public Product findByidService(int pid);

}
