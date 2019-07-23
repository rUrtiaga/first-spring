package com.example.springboot.model;

import java.io.Serializable;

public class Auto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String marca;
	private Integer anioDeFabricación;

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAnioDeFabricación() {
		return anioDeFabricación;
	}
	public void setAnioDeFabricación(Integer anioDeFabricación) {
		this.anioDeFabricación = anioDeFabricación;
	}
	
	
}
