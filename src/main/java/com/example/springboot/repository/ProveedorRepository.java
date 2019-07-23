package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.model.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long>  {

	Proveedor findByCodigo(int codigo);
}
