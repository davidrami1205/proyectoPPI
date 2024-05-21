package com.adminViajes.modelo.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.adminViajes.modelo.entidad.Usuario;
//import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

	Optional<Usuario> findByCorreo(String correo);

	boolean existsByCorreo(String correo);

	// Usuario findByCorreo(String correo);

	// Usuario findByContrasena(String contrasena);

}
