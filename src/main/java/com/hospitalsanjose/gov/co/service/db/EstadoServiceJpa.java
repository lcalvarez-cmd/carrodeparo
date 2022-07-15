package com.hospitalsanjose.gov.co.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalsanjose.gov.co.model.Estado;
import com.hospitalsanjose.gov.co.repository.EstadoRepository;
import com.hospitalsanjose.gov.co.service.IEstadoService;

@Service
public class EstadoServiceJpa implements IEstadoService{

	@Autowired
	private  EstadoRepository estadoRepo;
	
	@Override
	public Estado buscarporId(Integer id_estado) {
		Optional<Estado> opEstado = estadoRepo.findById(id_estado); 
		return opEstado.get();
	}

	@Override
	public List<Estado> buscarTodos() {
		return (List<Estado>) estadoRepo.findAll();
	}


}
