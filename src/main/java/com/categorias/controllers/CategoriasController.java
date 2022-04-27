package com.categorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.example.actividad.interfaces.Categorias;
import com.example.services.CategoriaServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Prueba de demostración",tags = {"Código de prueba para configurar el entorno"})
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriaServices categoriaServices;
	
	@PostMapping("/newCategoria")
	Categorias newCategoria(@RequestBody Categorias newCategoria) {
		return categoriaServices.save(newCategoria);
	}
	
	@GetMapping(value="/getAll")
	List<Categorias> all() {
		return (List<Categorias>) categoriaServices.findAll();
	}
	
	@ApiOperation (value = "Crea una categoria", notes="Crea la categoria al enviar el nombre y descripción.")
	@PostMapping(value = "/categoria")
	public ResponseEntity<?> create(@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServices.save(categoria));
	}
	
	@ApiOperation (value = "Busqueda de categoria", notes="Busca una categoria enviendo el id.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<Categorias> optionalCategorias = categoriaServices.findById(id);
		if (optionalCategorias.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optionalCategorias);
	}
}
