package com.adminViajes.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {
	@Id
	private int IdVehiculo;
	private String placa;
	private int NumeroInterno;

	private Vehiculos() {
		super();
	}

	public int getIdVehiculo() {
		return IdVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
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

	@Override
	public String toString() {
		return "Vehiculos [IdVehiculo=" + IdVehiculo + ", placa=" + placa + ", NumeroInterno=" + NumeroInterno + "]";
	}

}
