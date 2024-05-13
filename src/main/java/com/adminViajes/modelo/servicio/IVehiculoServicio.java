package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Vehiculos;

public interface IVehiculoServicio {
	public List<Vehiculos> listaTodos();

	public void guardar(Vehiculos vehiculos);

	public Vehiculos buscarPorId(Long id);

	public void eliminar(Long id);
}
