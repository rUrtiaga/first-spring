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
}
