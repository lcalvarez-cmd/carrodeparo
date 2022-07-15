package com.hospitalsanjose.gov.co.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cardio_vas_cambio")
public class Cardio_vas_cambio {
	
	@Id
	@Column(name = "id_cambio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cambio;
	private Date fecha_cambio;
	private String razon_cambio;
	@OneToOne(mappedBy = "cambio", cascade = CascadeType.ALL)
	private Cardio_vas_lote loteAntiguo;//lote que voy a cambiar
	@OneToOne
	@JoinColumn(name="id_lote_reemplazo", updatable = false, nullable = false)
	private Cardio_vas_lote loteNuevo;//lote por el que lo cambio
	
	public Cardio_vas_cambio() {}
	
	public Long getId_cambio() {
		return id_cambio;
	}
	public void setId_cambio(Long id_cambio) {
		this.id_cambio = id_cambio;
	}
	public Date getFecha_cambio() {
		return fecha_cambio;
	}
	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}
	public String getRazon_cambio() {
		return razon_cambio;
	}
	public void setRazon_cambio(String razon_cambio) {
		this.razon_cambio = razon_cambio;
	}
	public Cardio_vas_lote getLoteAntiguo() {
		return loteAntiguo;
	}
	public void setLoteAntiguo(Cardio_vas_lote loteAntiguo) {
		this.loteAntiguo = loteAntiguo;
	}
	public Cardio_vas_lote getLoteNuevo() {
		return loteNuevo;
	}
	public void setLoteNuevo(Cardio_vas_lote loteNuevo) {
		this.loteNuevo = loteNuevo;
	}
	
}
