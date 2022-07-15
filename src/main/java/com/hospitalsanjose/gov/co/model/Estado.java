package com.hospitalsanjose.gov.co.model;

import java.util.ArrayList;
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
@Table(name="estado")
public class Estado  {
	
	@Id
	@Column(name = "id_estado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado;
	private String estado;
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cardio_vas_lote> lotes;//un estado lo pueden tener muchos lotes un lote solo tiene un estado
	
	public Estado() {}
	public Estado(Integer id_estado, String estado, List<Cardio_vas_lote> lotes) {
		this.id_estado = id_estado;
		this.estado = estado;
		this.lotes = lotes;
	}
	
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Cardio_vas_lote> getLotes() {
		return lotes;
	}
	public void setLotes(List<Cardio_vas_lote> lotes) {
		this.lotes = lotes;
	}
	
	public void agrerarCardio_vas_lote(Cardio_vas_lote lote) {
		if(this.lotes == null) {
			this.lotes = new ArrayList<Cardio_vas_lote>();
		}
		this.lotes.add(lote);
	}
	
	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", estado=" + estado + ", lotes=" + lotes + "]";
	}
	
}
