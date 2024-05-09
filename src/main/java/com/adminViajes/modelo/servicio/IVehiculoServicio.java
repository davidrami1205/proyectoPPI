package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Vehiculos;

public interface IVehiculoServicio {
	public List<Vehiculos> listaTodos();
	public void guardar(Vehiculos vehiculos);
	public Vehiculos buscarPorId(Integer id);
	public void eliminar(Integer id);
}
