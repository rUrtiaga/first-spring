package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.producto.Producto;
import com.example.springboot.repository.ProductoReposotory;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoReposotory proRepo;
	
	@Override
	public Producto create(Producto producto) {
		this.proRepo.save(producto);
		return producto;
	}

}

