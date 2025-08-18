package com.codegym.shoeshopmanager.service;

import com.codegym.shoeshopmanager.repository.ProductReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductReposition productReposition;
    @Override
    public List findAll() {
        return productReposition.findAll();
    }

    @Override
    public Object findById(int id) {
        return productReposition.findById(id);
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List searchByName(String name) {
        return null;
    }
}
