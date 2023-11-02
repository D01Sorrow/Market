package com.primerapi.prueba1.proyectoprueba.domain.repository;

import java.util.List;
import java.util.Optional;

import com.primerapi.prueba1.proyectoprueba.domain.Product;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int idCategory);
    Optional<List<Product>> getByStock(int stock);
    Optional<Product> getProduct(int idProduct);
    Product save(Product product);
    void delete(int idProduct);
    
}
