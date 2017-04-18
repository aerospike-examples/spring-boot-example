package com.aerospike.spring.boot.example.repository;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.aerospike.spring.boot.example.domain.Product;

public interface ProductRepository extends AerospikeRepository<Product, Integer> {
}
