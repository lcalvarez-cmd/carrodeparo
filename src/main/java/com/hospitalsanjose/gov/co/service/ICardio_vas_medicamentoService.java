package com.hospitalsanjose.gov.co.service;

import java.util.List;

import com.hospitalsanjose.gov.co.model.Cardio_vas_medicamento;

public interface ICardio_vas_medicamentoService {
	
	Cardio_vas_medicamento buscarPorId(Long id);
	List<Cardio_vas_medicamento> buscarTodos();
	void guardar (Cardio_vas_medicamento medicamento);
	Cardio_vas_medicamento buscarporNombre(String medicamento);
}
