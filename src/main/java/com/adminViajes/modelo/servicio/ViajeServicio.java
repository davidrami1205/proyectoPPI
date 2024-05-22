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
    public List<Viaje> Listado() {
        return (List<Viaje>) viajeRepositorio.findAll();
    }

    @Override
    public void save(Viaje viaje) {
        viaje.setEstado("ACTIVO");
        viajeRepositorio.save(viaje);
    }

    @Override
    public void eliminar(Long id) {
        viajeRepositorio.deleteById(id);
    }

    @Override
    public Viaje buscarId(Long id) {
        return viajeRepositorio.findById(id).orElse(null);
    }

}
