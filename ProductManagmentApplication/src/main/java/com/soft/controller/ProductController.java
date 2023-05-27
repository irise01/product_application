package com.soft.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.Product;
import com.soft.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public HashMap<String, Object> saveNewProduct(@RequestBody Product product){
		 HashMap<String, Object> response = productService.addNewProdcutService(product);
		 
		 return response;
		 
	}
	
	@GetMapping("/getALLProduct")
	public List<Product> findALLProduct(){
		
		return productService.getAllProduct();
		
	}
	
	@DeleteMapping("/deleteById")
	public HashMap<String, Object> deletProductById(@RequestParam int pid){
		HashMap<String, Object> resposne = productService.deleteProductById(pid);
		return resposne;
	}
	
	@PostMapping("/updateProductByid")
	public HashMap<String, Object> updateProductById(@RequestBody Product product, @RequestParam int pid){
		HashMap<String, Object> response = productService.updateProductById(product, pid);
		
		return response;
	}
	
	@GetMapping("/findById/{pid}")
	public Product findById(@PathVariable int pid) {
		
		Product product = productService.findByidService(pid);
		return product;
	}

}



