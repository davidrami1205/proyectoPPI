package com.adminViajes.modelo.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Conductor;
import com.adminViajes.modelo.repositorio.ConductorRepositorio;

@Service
public class ConductorServicio implements IConductorService {

    @Autowired
    ConductorRepositorio conductorRepositorio;

    @Override
    public List<Conductor> findAll() {
        return (List<Conductor>) conductorRepositorio.findAll();
    }

    @Override
    public void save(Conductor conductor) {
        conductorRepositorio.save(conductor);
    }

    @Override
    public Conductor buscarId(Long id) {
        return conductorRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        conductorRepositorio.deleteById(id);
    }
}
