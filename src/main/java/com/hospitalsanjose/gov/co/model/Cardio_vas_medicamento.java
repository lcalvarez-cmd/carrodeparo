package com.hospitalsanjose.gov.co.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cardio_vas_medicamento")
public class Cardio_vas_medicamento {

	@Id
	@Column(name="id_medicamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_medicamento;
	private String nombre;
	private String firma_revision;
	private Date fecha_revision;
	@OneToMany(mappedBy = "cardio_vas_medicamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cardio_vas_lote> lotes;//un medicamento tiene varios lotes
	
	
	public Cardio_vas_medicamento() {}
	
	public Cardio_vas_medicamento(Long id_medicamento, String nombre, String firma_revision, Date fecha_revision) {
		this.id_medicamento = id_medicamento;
		this.nombre = nombre;
		this.firma_revision = firma_revision;
		this.fecha_revision = fecha_revision;
	}

	public Long getId_medicamento() {
		return id_medicamento;
	}
	public void setId_medicamento(Long id_medicamento) {
		this.id_medicamento = id_medicamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFirma_revision() {
		return firma_revision;
	}
	public void setFirma_revision(String firma_revision) {
		this.firma_revision = firma_revision;
	}
	public Date getFecha_revision() {
		return fecha_revision;
	}
	public void setFecha_revision(Date fecha_revision) {
		this.fecha_revision = fecha_revision;
	}
	public List<Cardio_vas_lote> getLotes() {
		return lotes;
	}
	public void setLotes(List<Cardio_vas_lote> lotes) {
		this.lotes = lotes;
	}

	public void agregarCardio_vas_lote(Cardio_vas_lote lote) {
		if(this.lotes == null) {
			this.lotes = new ArrayList<Cardio_vas_lote>();
		}
		this.lotes.add(lote);
	}
	
	@Override
	public String toString() {
		return "Cardio_vas_medicamento [id_medicamento=" + id_medicamento + ", nombre=" + nombre + ", firma_revision="
				+ firma_revision + ", fecha_revision=" + fecha_revision + "]";
	}

}
