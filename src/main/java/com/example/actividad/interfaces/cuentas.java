package com.example.actividad.interfaces;

import com.example.actividad.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface cuentas extends JpaRepository<Cuenta, Long>{
}
