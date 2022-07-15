package com.hospitalsanjose.gov.co.service;

import java.util.List;

import com.hospitalsanjose.gov.co.model.Estado;

public interface IEstadoService {

	Estado buscarporId(Integer id_estado);
	
	List<Estado> buscarTodos();
}
