package com.curso.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto implements Serializable {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_producto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private String precio;
    @Column(name = "cantidad")
    private Number cantiad;
	
}
