package com.codegym.manager.repostion;

import java.util.List;

public interface IGenerateReposition <A>{
    List<A> findAll();
    A findById(Long id);
    void save(A a);
    void remove(Long id);
    List<A> findByName(String name);
}
