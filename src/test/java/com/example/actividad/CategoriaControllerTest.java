package com.example.actividad;

import java.util.List;

import com.example.actividad.interfaces.Categorias;
import com.example.services.CategoriaServices;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CategoriaControllerTest {
    @Autowired
	private CategoriaServices categoriaServices;

    @Test
    @Order(1)
    @PostMapping("/newCategoria")
	Categorias newCategoria(@RequestBody Categorias newCategoria) {
		return categoriaServices.save(newCategoria);
	}

    @Test
    @Order(2)
    @GetMapping(value="/getAll")
	List<Categorias> all() {
		return (List<Categorias>) categoriaServices.findAll();
	}
	
    @Test
    @Order(3)
	@PostMapping(value = "/categoria")
	public ResponseEntity<?> create(@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServices.save(categoria));
	}
	
    @Test
    @Order(4)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		java.util.Optional<Categorias> optionalCategorias = categoriaServices.findById(id);
		if (optionalCategorias.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optionalCategorias);
	}
}
