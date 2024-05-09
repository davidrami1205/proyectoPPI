package com.adminViajes.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="viaje")
public class Viaje {

	@Id
	private Long idViaje;
	@ManyToOne
	@JoinColumn(name="idVehiculo")
	private Vehiculos vehiculo;
	@ManyToOne
	@JoinColumn(name="idRuta")
	private Ruta ruta;
	@ManyToOne
	@JoinColumn(name="idConductor")
	private Conductor conductor;
	
	
}
