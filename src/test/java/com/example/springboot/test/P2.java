package com.example.springboot.test;

import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.DemoApplication;
import com.example.springboot.dto.ClienteDTO;
import com.example.springboot.model.Proveedor;
import com.example.springboot.model.producto.General;
import com.example.springboot.model.producto.Gondola;
import com.example.springboot.model.producto.Producto;
import com.example.springboot.service.ClienteService;
import com.example.springboot.service.ProductoService;
import com.example.springboot.service.ProveedorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class P2 {
	@Autowired
	ClienteService clienteService;
	@Autowired
	ProveedorService proveedorService;
	@Autowired
	ProductoService productoService;
	@Test
	public void A_1_ProveedoresTest() throws SQLIntegrityConstraintViolationException {
		Proveedor p1 = new Proveedor(2312,"Venta de galletitas");
		Proveedor p2 = new Proveedor(2313,"Venta de Televisores");
		
		
		proveedorService.create(p1);
		proveedorService.create(p2);
		
		Proveedor provee1 = proveedorService.getProCodigo(2312);
		
		Producto pro1 = new Gondola("M01", "Lata de Maíz",new BigDecimal(30.00),200,provee1);
		Producto pro2 = new General("C01", "Cuchara", new BigDecimal(50.10), 20,provee1);
		
		productoService.create(pro1);
		productoService.create(pro2);
		
		ClienteDTO c1 = new ClienteDTO("c1","Castas","Juan","23");
		
		clienteService.create(c1);
		
	}


}
