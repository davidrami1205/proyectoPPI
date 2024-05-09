package com.adminViajes.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Vehiculos;
import com.adminViajes.modelo.repositorio.VehiculoRepositorio;

@Service
public class VehiculoServicio implements IVehiculoServicio{
	
	@Autowired
	
	private VehiculoRepositorio vehiculoRepositorio;
	
	@Override
	public List<Vehiculos> listaTodos() {
		return (List<Vehiculos>)vehiculoRepositorio.findAll();
	}

	@Override
	public void guardar(Vehiculos vehiculos) {
		vehiculoRepositorio.save(vehiculos);
	}

	@Override
	public Vehiculos buscarPorId(Integer id) {
		return vehiculoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		vehiculoRepositorio.deleteById(id);
	}

}
