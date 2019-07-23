package com.example.springboot.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Auto;

@RestController
@RequestMapping("demo")
public class DemoRESTController {

	private List<Auto> autos;
	
	public DemoRESTController() {
		super();
		this.autos = new ArrayList<Auto>();
	}
	
//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public Auto crearAuto(@RequestBody Auto nuevo) {
		this.addAuto(nuevo);
		return nuevo;
		
	}
	
//	@RequestMapping(name = "/findAll",method=RequestMethod.GET)
	@GetMapping("/findAll")
	public List<Auto> findAll(){
		return this.autos;
	}
	

//	@RequestMapping(value="/findByCodigo/{codigo}",method=RequestMethod.GET)
	@GetMapping("/findByCodigo/{codigo}")
	public Auto findByCodigo(@PathVariable("codigo") String codigo) throws Exception{
		Auto aut = this.autos.stream().filter(a-> a.getCodigo().equals(codigo)).findAny().orElse(null);
		if(aut == null) {
			throw new Exception("no se encontró el auto");
		}
		return aut;
	}

	
	//metodos alternativos
	private void addAuto(Auto auto) {
		this.autos.add(auto);
	}
	
	
}
