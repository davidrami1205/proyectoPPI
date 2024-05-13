package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Ruta;

public interface IRutaService {
    public List<Ruta> findAll();

    public void save(Ruta ruta);

    public void buscarId(Long id);

    public void eliminar(Long id);
}
