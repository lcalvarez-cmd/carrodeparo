package com.hospitalsanjose.gov.co.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalsanjose.gov.co.model.Cardio_vas_medicamento;
import com.hospitalsanjose.gov.co.repository.Cardio_vas_medicamentoRepository;
import com.hospitalsanjose.gov.co.service.ICardio_vas_medicamentoService;

@Service
public class Cardio_vas_medicamentoServiceJpa implements ICardio_vas_medicamentoService{

	@Autowired
	private Cardio_vas_medicamentoRepository medicamentoRepo;
	
	@Override
	public Cardio_vas_medicamento buscarPorId(Long id) {
		Optional<Cardio_vas_medicamento> objOp = medicamentoRepo.findById(id);
		return objOp.get();
	}

	@Override
	public List<Cardio_vas_medicamento> buscarTodos() {
		return (List<Cardio_vas_medicamento>) medicamentoRepo.findAll();
	}

	@Override
	public void guardar(Cardio_vas_medicamento medicamento) {
		medicamentoRepo.save(medicamento);		
	}

	@Override
	public Cardio_vas_medicamento buscarporNombre(String medicamento) {
		return medicamentoRepo.findByNombre(medicamento);
	}

}
