package com.azure.sample.cosmosdb.demo.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName =  "products")
public class Product {

    @Id
    private String productid;

    @PartitionKey
    private String productCategory;

    private String productName;

    private double price;


}