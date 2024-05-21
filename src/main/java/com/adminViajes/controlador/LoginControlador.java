package com.adminViajes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.UsuarioServicio;

@Controller
// @RequestMapping("/vistas")
public class LoginControlador {

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/login")
	public String login() {
		return "/vistas/login";
	}

	@GetMapping("/registrar")
	public String registrar(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("Titulo", "Formulario: Nuevo Usuario");
		modelo.addAttribute("Usuario", usuario);
		return "/vistas/registrar";
	}
}
