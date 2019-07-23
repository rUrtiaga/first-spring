package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	
}
