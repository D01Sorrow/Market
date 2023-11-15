package com.primerapi.prueba1.proyectoprueba.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primerapi.prueba1.proyectoprueba.domain.Product;
import com.primerapi.prueba1.proyectoprueba.domain.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int idProduct) { 
        return productRepository.getProduct(idProduct);
    }
    public Optional<List<Product>> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int idProduct){

        return productRepository.getProduct(idProduct).map(product -> {
            productRepository.delete(idProduct);
            return true;
        }).orElse(false);
    }

}
