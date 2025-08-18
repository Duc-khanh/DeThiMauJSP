package com.codegym.managephone.service;

import java.util.List;

public interface GenerateRepository <T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
