package com.codegym.managerproduct.service;

import com.codegym.managerproduct.model.Product;
import com.codegym.managerproduct.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iproductRepository;
    @Override
    public List<Product> findAll() {
        return iproductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iproductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iproductRepository.save(product);

    }

    @Override
    public void remove(Long id) {
        iproductRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
