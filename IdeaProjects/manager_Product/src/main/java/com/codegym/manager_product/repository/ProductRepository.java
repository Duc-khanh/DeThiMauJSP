package com.codegym.managerproduct.repository;

import com.codegym.managerproduct.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != null) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }

    }

    @Override
    public void remove(Long id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
