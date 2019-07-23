package com.example.springboot.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;


@Entity(name="Cliente")
@Table(name="CLIENTE")
public class Cliente {
	
	// Atributes
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
	private Long id;
	@NaturalId
	@Column(unique = true)
	private String codigo;
	@Column
	private String apellido;
	@Column
	private String nombre;
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cuenta_id", foreignKey=@ForeignKey(name="cuenta_cliente_id_fk"))
	private Cuenta cuenta;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name="cliente_id") // es mas performante sino te crea 3 tablas.
	private List<Factura> facturas;
	
	// Constructors
	public Cliente() {
		super();
	}
	
	public Cliente(String _codigo,String _apellido,String _nombre) {
		this.apellido = _apellido;
		this.nombre = _nombre;
		this.codigo = _codigo;
		this.cuenta = new Cuenta(this);
	}
	
	public Cliente(String codigo2, String apellido2, String nombre2, String numeroDeCuenta) {
		this(codigo2,apellido2,nombre2);
		this.cuenta = new Cuenta(this,numeroDeCuenta);
	}
	

	// metodos

	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo, cuenta, facturas, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(cuenta, other.cuenta) && Objects.equals(facturas, other.facturas)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	
	// Setters y Getters
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
