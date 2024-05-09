package com.adminViajes.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="novedad")
public class Novedad {
	
	@Id
	private Long idNovedad;
	private String tipoNovedad;
	private String observacion;
	
	public Novedad() {
		super();
	}

	public Long getIdNovedad() {
		return idNovedad;
	}

	public void setIdNovedad(Long idNovedad) {
		this.idNovedad = idNovedad;
	}

	public String getTipoNovedad() {
		return tipoNovedad;
	}

	public void setTipoNovedad(String tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}
