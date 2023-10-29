package com.primerapi.prueba1.proyectoprueba.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Column;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    
    @Column(name = "correo_electronico")
    private String correoElectronico;

}
