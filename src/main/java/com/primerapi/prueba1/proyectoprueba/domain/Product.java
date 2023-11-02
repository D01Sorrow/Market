package com.primerapi.prueba1.proyectoprueba.domain;

import lombok.Data;

@Data
public class Product {

    private int idProduct;
    private String name;
    private int idCategory;
    private double price;
    private int strock;
    private boolean active;
    private Category category;

    
}
