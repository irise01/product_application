package com.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
