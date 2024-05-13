package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Conductor;

public interface IConductorService {
    public List<Conductor> findAll();

    public void save(Conductor conductor);

    public void buscarId(Long id);

    public void eliminar(Long id);
}
