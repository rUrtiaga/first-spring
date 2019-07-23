package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.ClienteDTO;
import com.example.springboot.model.Cliente;
import com.example.springboot.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {

	//Autowired crea solo una instancia y la rellena (inyección de dependencias)
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteDTO create(ClienteDTO clienteDTO) {
		Cliente cliente  = null;
		cliente = new Cliente( 
				clienteDTO.getCodigo(),clienteDTO.getApellido(),clienteDTO.getNombre(),clienteDTO.getNumeroDeCuenta());
		
		this.clienteRepository.save(cliente);			
		return new ClienteDTO(cliente);
	}

}
