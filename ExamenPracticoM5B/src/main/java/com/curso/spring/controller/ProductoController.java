package com.curso.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.model.Producto;
import com.curso.spring.service.ProductoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/producto")
public class ProductoController {

	   @Autowired
	    ProductoService productoService;
	    

	    @GetMapping("/listar")
	    public ResponseEntity< List<Producto>> obtenerLista() {
	        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
	    }
	    
	    @PostMapping("/crear")
	    public ResponseEntity<Producto> crear(@RequestBody Producto pr){
	     return new ResponseEntity<>(productoService.save(pr), HttpStatus.CREATED);
	    }
	    
	      @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Producto> eliminar(@PathVariable Integer id) {
	        productoService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @PutMapping("/actualizar/{id}")
	    public ResponseEntity<Producto> actualizarUsuario(@PathVariable Integer id, @RequestBody Producto pr) {
	        Producto producto = productoService.findById(id);
	        if (producto == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            try {
	            	producto.setNombre(pr.getNombre));
	            	Producto.setDescripcon(pr.getDescripcion));
	               
	                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
	            } catch (Exception e) {
	                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	            }

	        }

	    }

}
