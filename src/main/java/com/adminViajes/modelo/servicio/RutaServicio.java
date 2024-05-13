package com.adminViajes.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adminViajes.modelo.entidad.Ruta;
import com.adminViajes.modelo.repositorio.RutaRepositorio;

public class RutaServicio implements IRutaService {

    @Autowired
    RutaRepositorio rutaRepositorio;

    @Override
    public List<Ruta> findAll() {
        return (List<Ruta>) rutaRepositorio.findAll();
    }

    @Override
    public void save(Ruta ruta) {
        rutaRepositorio.save(ruta);
    }

    @Override
    public void buscarId(Long id) {
        rutaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long Id) {
        rutaRepositorio.deleteById(Id);
    }
}
