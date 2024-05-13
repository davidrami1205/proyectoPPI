package com.adminViajes.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio implements IUsuarioService {

	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuariorepositorio.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuario.setRol("USER");
		usuario.setEstado("ACTIVO");
		usuariorepositorio.save(usuario);
	}

	@Override
	public Usuario buscarCorreo(String correo) {
		return usuariorepositorio.findByCorreo(correo);
	}

	@Override
	public Usuario buscarContrasena(String contrasena) {
		return usuariorepositorio.findByContrasena(contrasena);
	}

	@Override
	public void eliminar(Integer id) {
		usuariorepositorio.deleteById(id);
	}

}
