package com.azure.sample.cosmosdb.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azure.sample.cosmosdb.demo.entity.Product;
import com.azure.sample.cosmosdb.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    
    @Autowired
    private ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping(value = "/{id}/category/{category}")
    public Optional<Product> get(@PathVariable String id, @PathVariable String category) {
        return productService.findById(id, category);
    }

    @DeleteMapping(value = "/{id}/category/{category}")
    public void delete(@PathVariable String id, @PathVariable String category) {
        productService.delete(id, category);
    }

    @GetMapping
    public List<Product> getByName(@RequestParam String name) {
        return productService.findProductByName(name);
    }

}
