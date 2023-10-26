package com.primerapi.prueba1.proyectoprueba.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK compraProductoPK;
    
    private Integer cantidad;

    private Double total;

    private Boolean estado;

    public CompraProductoPK getCompraProductoPK() {
        return compraProductoPK;
    }

    public void setCompraProductoPK(CompraProductoPK compraProductoPK) {
        this.compraProductoPK = compraProductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}
