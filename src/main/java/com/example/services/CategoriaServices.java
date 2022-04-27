package com.example.services;

import java.util.Optional;

import com.example.actividad.interfaces.Categorias;

public interface CategoriaServices {
	
	public Iterable<Categorias> findAll();
	
	public Optional<Categorias> findById(Long id);
	
	public Categorias save(Categorias categorias);
	
	public void delete(Long id);
}
