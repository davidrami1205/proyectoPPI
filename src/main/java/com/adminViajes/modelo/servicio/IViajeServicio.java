package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Viaje;

public interface IViajeServicio {
    public List<Viaje> findAll();

    public void save(Viaje viaje);

    public void eliminar(Long id);

    public void buscarId(Long id);
}
