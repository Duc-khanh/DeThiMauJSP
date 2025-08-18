package com.codegym.managerproduct.service;

import java.util.List;

public interface IGenerateService<P> {
    List<P> findAll();
    P findById(Long id);
    void save(P p);
    void remove(Long id);
    List<P> findByName(String name);
}
