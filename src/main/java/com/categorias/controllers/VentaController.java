package com.categorias.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.actividad.interfaces.Model;
import com.example.repository.VentaRepository;

public class VentaController {
	
	private VentaRepository ventaRepository;
	@GetMapping
	private ResponseEntity<List<Model>> getProductos(){
		return ResponseEntity.ok(ventaRepository.productos());
	}
}
