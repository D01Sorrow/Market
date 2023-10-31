package com.primerapi.prueba1.proyectoprueba.persistence;

import com.primerapi.prueba1.proyectoprueba.persistence.crud.ProductoCrudRepository;
import com.primerapi.prueba1.proyectoprueba.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll(){
        
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(Integer idCategoria){
        
        return (List<Producto>) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getByCantidadStockAndEstado(Integer cantidadStock, Boolean estado){

        return  productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }
    public Optional<Producto> getProducto(Integer idProducto){

        return productoCrudRepository.findById(idProducto);
    }   
    public Producto save(Producto producto){

        return productoCrudRepository.save(producto);
    }
    public void delete(Integer idProducto){

        productoCrudRepository.deleteById(idProducto);
    }
}
