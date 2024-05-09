package com.adminViajes.modelo.servicio;

import java.util.List;

import com.adminViajes.modelo.entidad.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public Usuario buscarCorreo(String correo);
	public Usuario buscarContrasena(String contrasena);
	public void eliminar(Integer id);
}
