package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.actividad.interfaces.Model;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoRepository extends JpaRepository<Model, Long>{

}
