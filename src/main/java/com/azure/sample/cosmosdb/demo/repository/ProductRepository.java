package com.azure.sample.cosmosdb.demo.repository;

import com.azure.sample.cosmosdb.demo.entity.Product;
import com.azure.spring.data.cosmos.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
    List<Product> findByProductName(String productName);

}