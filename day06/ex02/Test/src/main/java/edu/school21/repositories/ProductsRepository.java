package edu.school21.repositories;


import edu.school21.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void delete(Long id);
    public void save(Product product);
    public void update(Product product);

}
