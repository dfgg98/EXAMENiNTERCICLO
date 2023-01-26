package com.curso.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	 @Query(value = "Select * from producto pr where pr.nombre = :nombre", nativeQuery = true)
	    public Producto buscarProducto(String nombre);
	
}
