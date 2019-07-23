package com.example.springboot.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.FacturaDTO;
import com.example.springboot.service.FacturaService;

@RestController
@RequestMapping("/factura")	
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;

	@PostMapping("/")
	public ResponseEntity<FacturaDTO> create(@RequestBody FacturaDTO facturaDTO) {
		facturaDTO = this.facturaService.create(facturaDTO);
		return new ResponseEntity<FacturaDTO>(facturaDTO,HttpStatus.CREATED);
	}
}
