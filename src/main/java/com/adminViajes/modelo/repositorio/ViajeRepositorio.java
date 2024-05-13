package com.adminViajes.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.adminViajes.modelo.entidad.Viaje;

public interface ViajeRepositorio extends CrudRepository<Viaje, Long> {

}
