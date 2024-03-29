package com.example.springboot.model.producto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.example.springboot.model.*;

@Entity(name="Producto")
@Table(name="PRODUCTO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Producto {
	@Id
	@GeneratedValue
	//(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
//	@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native") 
	private Long id;
	@NaturalId
	@Column(unique = true)
	private String codigo;
	private String descripcion;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "precio_id", foreignKey=@ForeignKey(name="precio_producto_id_fk"))
	private Precio precio;
	@ManyToMany
	private List<Proveedor> proveedores = new ArrayList<Proveedor>();
	
	
	public Producto() {
		super();
	}

	public Producto(Proveedor proveedor) {
		this.proveedores.add(proveedor);
	}

	
	
	public Producto(String c,String d,BigDecimal precio) {
		this.codigo = c;
		this.descripcion = d;
		this.newPrecio(precio);
	}
	
	public Producto(String codigo, String desc) {
		this.codigo = codigo;
		this.descripcion = desc;
	}


	public Producto(String c,String d,BigDecimal precio,Proveedor proveedor) {
		this(proveedor);
		this.codigo = c;
		this.descripcion = d;
		this.newPrecio(precio);
	}
	
	public Producto(String codigo, String desc,Proveedor proveedor) {
		this(proveedor);
		this.codigo = codigo;
		this.descripcion = desc;
	}

	
	
	//Methodos abstractos
	public abstract BigDecimal getPrecioFinal();
	
	protected BigDecimal calcularPrecioConRecargo(double procentajeDeRecargo) {
		BigDecimal monto = this.getPrecio().getMonto();
		return monto.multiply(new BigDecimal(procentajeDeRecargo)).add(monto);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Precio getPrecio() {
		return precio;
	}
	public void setPrecio(Precio precio) {
		this.precio = precio;
	}
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public void addProveedor(Proveedor pro) {
		this.getProveedores().add(pro);
		pro.getProductos().add(this);
	}

	public void newPrecio(BigDecimal precio) {
		this.precio = new Precio(precio,this);
	}
}
