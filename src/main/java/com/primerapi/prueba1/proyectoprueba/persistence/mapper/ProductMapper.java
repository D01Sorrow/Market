package com.primerapi.prueba1.proyectoprueba.persistence.mapper;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.primerapi.prueba1.proyectoprueba.persistence.entity.Producto;
import com.primerapi.prueba1.proyectoprueba.domain.Product;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    
    @Mappings({
        @Mapping(source = "idProducto", target = "idProduct"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "idCategoria", target = "idCategory"),
        @Mapping(source = "precio", target = "price"),
        @Mapping(source = "cantidadStock", target = "stock"),
        @Mapping(source = "estado", target = "active"),
        @Mapping(source = "categoria", target = "category")
    })
    Product toProduct (Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
