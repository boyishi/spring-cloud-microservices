package com.demo.boyishi.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.boyishi.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
