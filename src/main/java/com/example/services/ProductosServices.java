package com.example.services;

import java.util.Optional;

import com.example.actividad.interfaces.Model;


public interface ProductosServices {
	
	public Iterable<Model> findAll();
	
	public Optional<Model> findById(Long id);
	
	public Model save(Model categorias);
	
	public void delete(Long id);
}
