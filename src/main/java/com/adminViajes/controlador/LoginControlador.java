package com.adminViajes.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {
	
	@GetMapping("/login")
	public String login() {
		return "/vistas/login";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "/vistas/registrar";
	}
}
