package com.codegym.managerproduct.repository;

import java.util.List;

public interface IGenerateRepository<P> {
    List<P> findAll();
    P findById(Long id);
    void save(P p);
    void remove(Long id);
    List<P> findByName(String name);
}
