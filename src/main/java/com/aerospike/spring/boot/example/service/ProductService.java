package com.aerospike.spring.boot.example.service;

import com.aerospike.spring.boot.example.domain.Product;

public interface ProductService {
	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);

	void deleteProduct(Integer id);
}