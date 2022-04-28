package com.example.actividad;

import java.util.Optional;

import com.example.actividad.interfaces.Model;
import com.example.services.ProductosServices;

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
public class ProductoControllerTest {
    @Autowired
	private ProductosServices productoServices;
	
    @Test
    @Order(1)
	@PostMapping("/created")
	public ResponseEntity<?> create(@RequestBody Model productos){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServices.save(productos));
	}
	
    @Test
    @Order(2)
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<Model> optionalProductos = productoServices.findById(id);
		if (optionalProductos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optionalProductos);
	}
}
