package com.adminViajes.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Viaje;
import com.adminViajes.modelo.repositorio.ViajeRepositorio;

@Service
public class ViajeServicio implements IViajeServicio {

    @Autowired
    ViajeRepositorio viajeRepositorio;

    @Override
    public List<Viaje> findAll() {
        return (List<Viaje>) viajeRepositorio.findAll();
    }

    @Override
    public void save(Viaje viaje) {
        viajeRepositorio.save(viaje);
    }

    @Override
    public void eliminar(Long id) {
        viajeRepositorio.deleteById(id);
    }

    @Override
    public void buscarId(Long id) {
        viajeRepositorio.findById(id).orElse(null);
    }

}
