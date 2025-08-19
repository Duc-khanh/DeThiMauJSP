package com.example.springbootbt.springboottest.service.product;


import com.example.springbootbt.springboottest.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> searchByName(String name);
    List<Product> searchByCategory(String category);
}