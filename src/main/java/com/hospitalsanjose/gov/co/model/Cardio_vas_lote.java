package com.hospitalsanjose.gov.co.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cardio_vas_lote")
public class Cardio_vas_lote {

	@Id
	@Column(name = "id_lote")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lote;
	private String lote;
	private Date fecha_vencimiento;
	private Integer cantidad;
	private String registro_invima;
	private String concentracion;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_estado")
	private Estado estado;//Un lote tiene un solo estado
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_medicamento")
	private Cardio_vas_medicamento cardio_vas_medicamento ; //un lote tiene un medicamento
	@OneToOne
	@JoinColumn(name="id_cambio", updatable = false, nullable=false)
	private Cardio_vas_cambio cambio;//lote que voy a cambiar
	@OneToOne(mappedBy = "loteNuevo")
	private Cardio_vas_cambio porcuallote;//lote por el que lo cambie
	
	public Cardio_vas_lote() {}

	public Cardio_vas_lote(Long id_lote, String lote, Date fecha_vencimiento, Integer cantidad, String registro_invima,
			String concentracion, Estado estado) {
		this.id_lote = id_lote;
		this.lote = lote;
		this.fecha_vencimiento = fecha_vencimiento;
		this.cantidad = cantidad;
		this.registro_invima = registro_invima;
		this.concentracion = concentracion;
		this.estado = estado;
	}
	public Long getId_lote() {
		return id_lote;
	}
	public void setId_lote(Long id_lote) {
		this.id_lote = id_lote;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getRegistro_invima() {
		return registro_invima;
	}
	public void setRegistro_invima(String registro_invima) {
		this.registro_invima = registro_invima;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Cardio_vas_medicamento getCardio_vas_medicamento() {
		return cardio_vas_medicamento;
	}
	public void setCardio_vas_medicamento(Cardio_vas_medicamento cardio_vas_medicamento) {
		this.cardio_vas_medicamento = cardio_vas_medicamento;
	}
	public Cardio_vas_cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cardio_vas_cambio cambio) {
		this.cambio = cambio;
	}
	public Cardio_vas_cambio getPorcuallote() {
		return porcuallote;
	}
	public void setPorcuallote(Cardio_vas_cambio porcuallote) {
		this.porcuallote = porcuallote;
	}

	@Override
	public String toString() {
		return "Cardio_vas_lote [id_lote=" + id_lote + ", lote=" + lote + ", fecha_vencimiento=" + fecha_vencimiento
				+ ", cantidad=" + cantidad + ", registro_invima=" + registro_invima + ", concentracion=" + concentracion
				+ ", estado=" + estado + "]";
	}
}
