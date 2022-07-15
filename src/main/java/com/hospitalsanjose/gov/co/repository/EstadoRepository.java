package com.hospitalsanjose.gov.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hospitalsanjose.gov.co.model.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {
	
//	Optional<Estado> findById(Integer id_estado);
}
