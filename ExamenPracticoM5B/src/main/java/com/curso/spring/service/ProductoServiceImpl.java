package com.curso.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.curso.spring.model.Producto;
import com.curso.spring.repository.ProductoRepository;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public CrudRepository<Producto, Integer> getDao() {
		// TODO Auto-generated method stub
		return productoRepository;
		
	}

	 public Producto buscarProducto(String nombre) {
	        return productoRepository.buscarProducto(nombre);
	    }

	

}
