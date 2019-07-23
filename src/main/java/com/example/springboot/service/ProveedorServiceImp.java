package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Proveedor;
import com.example.springboot.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public Proveedor create(Proveedor proveedor) {
//		Proveedor proveedor  = null;
//		proveedor = new Proveedor();
		
		this.proveedorRepository.save(proveedor);			
		return proveedor;
	}

	@Override
	public List<Proveedor> get() {
		List<Proveedor> res = new ArrayList<>();
		Iterable<Proveedor> ite = this.proveedorRepository.findAll();
		ite.forEach(res::add);
		return res;
	}

	@Override
	public Proveedor get(Long id_proveedor) {
		Optional<Proveedor> pro = this.proveedorRepository.findById(id_proveedor);
		if(!pro.isPresent()) {			
			throw new Error("Falló");
		}
		
		return pro.get();
	}

	@Override
	public Proveedor getProCodigo(int codigo) {
		return this.proveedorRepository.findByCodigo(codigo);
	}
}
