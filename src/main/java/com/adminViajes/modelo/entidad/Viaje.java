package com.adminViajes.modelo.entidad;

import java.sql.Time;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
@Table(name = "viaje")
public class Viaje {

	@Id
	@Column(name = "idViaje")
	private Long idViaje;
	@Column(name = "horaInicio")
	private DateTime horaInicio;
	@Column(name = "horaFin")
	private DateTime horaFin;
	@Column(name = "duracion")
	private Time duracion;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idVehiculo")
	private Vehiculos vehiculos;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idRuta")
	private Ruta ruta;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idConductor")
	private Conductor conductor;

	public Viaje() {
		super();
	}

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public DateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(DateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public DateTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(DateTime horaFin) {
		this.horaFin = horaFin;
	}

	public Time getDuracion() {
		return duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

}
