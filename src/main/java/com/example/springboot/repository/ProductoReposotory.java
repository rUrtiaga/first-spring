package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.producto.Producto;

@Repository
public interface ProductoReposotory extends CrudRepository<Producto, Long> {

	
}
