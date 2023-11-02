package com.primerapi.prueba1.proyectoprueba.persistence;

import com.primerapi.prueba1.proyectoprueba.domain.Product;
import com.primerapi.prueba1.proyectoprueba.domain.repository.ProductRepository;
import com.primerapi.prueba1.proyectoprueba.persistence.crud.ProductoCrudRepository;
import com.primerapi.prueba1.proyectoprueba.persistence.entity.Producto;
import com.primerapi.prueba1.proyectoprueba.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository  {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;
    
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>)productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }  
    @Override
    public void delete(int idProducto){

        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategory) {
        
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByStock(int stock) {
        
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(stock, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int idProduct) {
        
        Optional<Producto> producto  = productoCrudRepository.findById(idProduct);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


}
