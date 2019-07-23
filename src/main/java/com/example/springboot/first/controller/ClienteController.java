package com.example.springboot.first.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.ClienteDTO;
import com.example.springboot.service.ClienteService;

@RestController
@RequestMapping("/cliente")	
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/")
//	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) throws SQLIntegrityConstraintViolationException{
			clienteDTO = this.clienteService.create(clienteDTO);
		return new ResponseEntity<ClienteDTO>(clienteDTO,HttpStatus.CREATED);
	}
}
