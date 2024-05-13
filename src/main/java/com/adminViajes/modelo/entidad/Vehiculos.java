package com.adminViajes.modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {
	@Id
	@Column(name = "idVehiculo")
	private Long IdVehiculo;
	@Column(name = "placa")
	private String placa;
	@Column(name = "numeroInterno")
	private int NumeroInterno;
	@OneToMany(mappedBy = "vehiculos", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Viaje> listaViajes;

	private Vehiculos() {
		super();
	}

	public Long getIdVehiculo() {
		return IdVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		IdVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNumeroInterno() {
		return NumeroInterno;
	}

	public void setNumeroInterno(int numeroInterno) {
		NumeroInterno = numeroInterno;
	}

	public List<Viaje> getListaViajes() {
		return listaViajes;
	}

	public void setListaViajes(List<Viaje> listaViajes) {
		this.listaViajes = listaViajes;
	}

}
