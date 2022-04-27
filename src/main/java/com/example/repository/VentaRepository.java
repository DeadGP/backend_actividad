package com.example.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.actividad.interfaces.Model;


@FeignClient(name="venta", url="http://localhost:/8080")
public interface VentaRepository {
	@RequestMapping(method = RequestMethod.GET)
	public List<Model> productos();
}
