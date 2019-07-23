package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
