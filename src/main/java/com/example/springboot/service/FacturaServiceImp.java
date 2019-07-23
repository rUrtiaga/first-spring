package com.example.springboot.service;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.FacturaDTO;
import com.example.springboot.model.Cliente;
import com.example.springboot.model.Factura;
import com.example.springboot.model.producto.Producto;
import com.example.springboot.repository.ClienteRepository;
import com.example.springboot.repository.FacturaRepository;
import com.example.springboot.repository.ProductoReposotory;
import com.example.springboot.utils.Pair;

@Service
public class FacturaServiceImp implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProductoReposotory productoRepository;
	
	@Override
	public FacturaDTO create(FacturaDTO facturaDTO) {
		Factura factura = null;
		//Traigo el cliente, en base al id
		Cliente cliente = clienteRepository.findById(facturaDTO.getIdCliente()).get();
		ArrayList<Entry<Producto, Integer>> productosConCantidad = new ArrayList<Entry<Producto,Integer>>();
		//Traigo y lleno una lista con los productos y las cantidades
		facturaDTO.getDetallesDTO().stream().forEach(detalleDTO -> {
			productosConCantidad.add(Pair.of(productoRepository.findById(detalleDTO.getId_producto()).get(),detalleDTO.getCantidad()));});
		//creo la factura Modelo
		factura = new Factura(cliente,productosConCantidad,facturaDTO.getFecha());
		this.facturaRepository.save(factura);
				
		return null;
	}

}
