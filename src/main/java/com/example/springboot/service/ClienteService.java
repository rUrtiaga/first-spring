package com.example.springboot.service;

import java.sql.SQLIntegrityConstraintViolationException;

import com.example.springboot.dto.ClienteDTO;

public interface ClienteService {

	public ClienteDTO create(ClienteDTO clienteDTO) throws SQLIntegrityConstraintViolationException;
}
