package com.codegym.shoeshopmanager.service;

import java.util.List;

public interface IProductService <T>{
    List <T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);
    List<T> searchByName(String name);
}
