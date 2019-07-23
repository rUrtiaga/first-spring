package com.example.springboot.dto;

import com.example.springboot.model.Detalle;

public class DetalleDTO {
	private Long id_producto;
	private int cantidad;
	
	DetalleDTO(){
		super();
	}
	DetalleDTO(Long id_producto,int cantidad){
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}
	
	public DetalleDTO(Detalle detalle) {
		this.id_producto = detalle.getProducto().getId();
		this.cantidad = detalle.getCantidad();
	}
	
	public Long getId_producto() {
		return id_producto;
	}
	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
