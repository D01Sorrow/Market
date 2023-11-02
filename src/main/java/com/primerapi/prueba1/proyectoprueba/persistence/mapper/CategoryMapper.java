package com.primerapi.prueba1.proyectoprueba.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.primerapi.prueba1.proyectoprueba.domain.Category;
import com.primerapi.prueba1.proyectoprueba.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source = "idCategoria", target = "idCategory"),
        @Mapping(source = "descripcion", target = "description"),
        @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
