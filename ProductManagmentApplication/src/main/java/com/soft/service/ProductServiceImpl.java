package com.soft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.model.Product;
import com.soft.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public HashMap<String, Object> addNewProdcutService(Product product) {

		HashMap<String, Object> serviceResponse = new HashMap<>();
		
		try {
			Product saveProduct = productRepository.save(product);
			if(product != null) {
				serviceResponse.put("message", "Product added sucessfully...!");
				serviceResponse.put("status", true);
				serviceResponse.put("SaveProductdata", saveProduct);
			}else {
				serviceResponse.put("message", "Product not added sucessfully...!");
				serviceResponse.put("status", false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public HashMap<String, Object>  deleteProductById(int pid) {
		HashMap<String, Object> response = new HashMap<>();
		
		if(productRepository.existsById(pid)) {
			productRepository.deleteById(pid);
			response.put("message", "Product deleted...!");
			response.put("status", true);
		}else {
			response.put("message", "Product not deleted...!");
			response.put("status", false);
			
		}
		return response;
		
	}

	@Override
	public HashMap<String, Object> updateProductById(Product product, int pid) {
		
		HashMap<String, Object> response = new HashMap<>();
		Optional<Product> checkProduct = productRepository.findById(pid);
		if(checkProduct.isPresent()) {
			
			Product updatedProdcut = checkProduct.get();
			updatedProdcut.setPname(product.getPname());
			updatedProdcut.setPqty(product.getPqty());
			updatedProdcut.setPrice(product.getPrice());
			
			response.put("Updateddata::", productRepository.save(updatedProdcut));
			response.put("message", "Product updated sucessfull...");
			response.put("status", true);
			
			
		}else {
			response.put("message", "Product not updated please check pid...");
			response.put("status", false);
			
		}
			
		return response;
	}

	@Override
	public Product findByidService(int pid) {
		Optional<Product> checkProduct = productRepository.findById(pid);
		Product product = null;
		if(checkProduct.isPresent()) {
			product = checkProduct.get();
		}else {
			product = null;
		}
		return product;
	}

}
