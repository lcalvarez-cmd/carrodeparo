package com.hospitalsanjose.gov.co.repository;

import org.springframework.data.repository.CrudRepository;

import com.hospitalsanjose.gov.co.model.Cardio_vas_lote;

public interface Cardio_vas_loteRepository extends CrudRepository<Cardio_vas_lote, Long> {

	Cardio_vas_lote findByLote(String lote);
	
}
