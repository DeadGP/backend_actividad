package com.categorias.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad.interfaces.Model;
import com.example.services.ProductosServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductosServices productoServices;
	
	@ApiOperation (value = "Registra un producto", notes="Registra un nuevo producto al enviar el nombre y descripción.")
	@PostMapping("/created")
	public ResponseEntity<?> create(@RequestBody Model productos){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServices.save(productos));
	}
	
	@ApiOperation (value = "Busca producto", notes="Busca un producto al enviarle el ID.")
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<Model> optionalProductos = productoServices.findById(id);
		if (optionalProductos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optionalProductos);
	}
}
