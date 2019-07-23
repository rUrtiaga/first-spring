package com.example.springboot.dto;

import com.example.springboot.model.Cliente;

//DTO Data Transfer Object
public class ClienteDTO{

	private Long id;
	private String codigo;
	private String apellido;
	private String nombre;
	private Long idCuenta;
	private String numeroDeCuenta;
	
	ClienteDTO(){
		super();
	}
	
	public ClienteDTO(String codigo, String apellido,String nombre, String numCuenta){
		this.setCodigo(codigo);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setNumeroDeCuenta(numCuenta);
	}
	
	public ClienteDTO(Cliente cliente) {
		this(cliente.getCodigo(),cliente.getApellido(),cliente.getNombre(),cliente.getCuenta().getNumero());
		this.setId(cliente.getId());
		this.setIdCuenta(cliente.getCuenta().getId());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
