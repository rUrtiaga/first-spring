package com.example.springboot.service;


import java.util.List;

import com.example.springboot.model.Proveedor;

public interface ProveedorService {

	public Proveedor create(Proveedor proveedor);

	public List<Proveedor> get();

	Proveedor get(Long id_proveedor);

	public Proveedor getProCodigo(int i);
}
