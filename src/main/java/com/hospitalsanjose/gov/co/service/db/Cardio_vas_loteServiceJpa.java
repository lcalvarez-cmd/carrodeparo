package com.hospitalsanjose.gov.co.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalsanjose.gov.co.model.Cardio_vas_lote;
import com.hospitalsanjose.gov.co.repository.Cardio_vas_loteRepository;
import com.hospitalsanjose.gov.co.service.ICardio_vas_loteService;

@Service
public class Cardio_vas_loteServiceJpa implements ICardio_vas_loteService{

	@Autowired
	private Cardio_vas_loteRepository loteService;
	
	@Override
	public void guardar(Cardio_vas_lote lote) {
		loteService.save(lote);		
	}

	@Override
	public void eliminar(Long id_lote) {
		loteService.deleteById(id_lote);		
	}

	@Override
	public List<Cardio_vas_lote> buscarTodos() {
		return (List<Cardio_vas_lote>) loteService.findAll();
	}

	@Override
	public Cardio_vas_lote buscarPorId(Long id_lote) {
		Optional<Cardio_vas_lote> lote = loteService.findById(id_lote);
		return lote.get();
	}

	@Override
	public Cardio_vas_lote buscarPorLote(String lote) {
		return loteService.findByLote(lote);
	}

}
