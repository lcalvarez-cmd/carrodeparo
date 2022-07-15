package com.hospitalsanjose.gov.co.repository;

import org.springframework.data.repository.CrudRepository;

import com.hospitalsanjose.gov.co.model.Cardio_vas_medicamento;

public interface Cardio_vas_medicamentoRepository extends CrudRepository<Cardio_vas_medicamento, Long> {
	Cardio_vas_medicamento findByNombre(String nombre);
}
