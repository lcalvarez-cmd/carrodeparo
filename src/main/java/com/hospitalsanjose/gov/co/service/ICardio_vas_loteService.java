package com.hospitalsanjose.gov.co.service;

import java.util.List;

import com.hospitalsanjose.gov.co.model.Cardio_vas_lote;

public interface ICardio_vas_loteService {

	void guardar(Cardio_vas_lote lote);
	void eliminar(Long id_lote);
	List<Cardio_vas_lote> buscarTodos();
	Cardio_vas_lote buscarPorId(Long id_lote);
	Cardio_vas_lote buscarPorLote(String lote);
}
