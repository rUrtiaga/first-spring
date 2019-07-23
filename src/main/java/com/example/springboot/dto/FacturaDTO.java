package com.example.springboot.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springboot.model.Detalle;
import com.example.springboot.model.Factura;


public class FacturaDTO {
	private int id;
	private Long idCliente;
	private LocalDate fecha;
	private int numero;
	private List<DetalleDTO> detallesDTO;

	FacturaDTO(){
		super();
	}
	
	FacturaDTO(Factura factura){
		this.id = factura.getId();
		this.idCliente = factura.getCliente().getId();
		this.fecha = factura.getFecha();
		this.numero = factura.getNumero();
		this.detallesDTO = this.detallesToDTO(factura.getDetalles());
	}


	///TODO FIX
//	private List<Detalle> detallesDTOToDetalles(List<DetalleDTO> detallesDTO) {
//		return detallesDTO.stream().map(detalle -> {
//			return new Detalle(factura,);
//		}).collect(Collectors.toList());
//	}

	
	private List<DetalleDTO> detallesToDTO(List<Detalle> detalles) {
		return detalles.stream().map(detalle -> {
			return new DetalleDTO(detalle);
		}).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<DetalleDTO> getDetallesDTO() {
		return detallesDTO;
	}

	public void setDetallesDTO(List<DetalleDTO> detallesDTO) {
		this.detallesDTO = detallesDTO;
	}

//	RAMIRO KESADA PONS artista, 
	
//	public ArrayList<Entry<Long, Integer>> detallesDTOtoEntry() {
//		return this.detallesDTO.stream().map(detalleDTO -> {
//			return Pair.of(detalleDTO.getId_producto(),detalleDTO.getCantidad());
//		}).collect(Collectors.toList());
//	}

//	private void productosToDetallles(ArrayList<Entry<Producto, Integer>> productos) {
//		List<Detalle> detalles;
//		detalles = productos.stream().map(entry -> {
//			return new Detalle(this,entry.getKey(),entry.getValue());
//		}).collect(Collectors.toList());
//		
//		this.setDetalles(new ArrayList<Detalle>(detalles));
//	}
}
