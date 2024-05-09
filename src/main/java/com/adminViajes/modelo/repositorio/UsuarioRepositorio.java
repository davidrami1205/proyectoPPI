package com.adminViajes.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.adminViajes.modelo.entidad.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

	Usuario findByCorreo(String correo);

	Usuario findByContrasena(String contrasena);

}
