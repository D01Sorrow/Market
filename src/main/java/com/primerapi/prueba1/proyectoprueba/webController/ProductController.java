package com.primerapi.prueba1.proyectoprueba.webController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primerapi.prueba1.proyectoprueba.domain.Product;
import com.primerapi.prueba1.proyectoprueba.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }
    public Optional<Product> getProduct(int idProduct) { 
        return productService.getProduct(idProduct);
    }
    public Optional<List<Product>> getByCategory(int idCategory){
        return productService.getByCategory(idCategory);
    }
    public Product save(Product product){
        return productService.save(product);
    }
    public boolean delete(int idProduct){

        return productService.getProduct(idProduct).map(product -> {
            productService.delete(idProduct);
            return true;
        }).orElse(false);
    }
    
}
