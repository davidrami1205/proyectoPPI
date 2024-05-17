package com.adminViajes.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Ruta;
import com.adminViajes.modelo.repositorio.RutaRepositorio;

@Service
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
    public Ruta buscarId(Long id) {
        return rutaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long Id) {
        rutaRepositorio.deleteById(Id);
    }
}
