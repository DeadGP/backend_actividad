package com.example.actividad.interfaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private Integer precio;

    public Model(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }
}
