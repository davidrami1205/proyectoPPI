package com.adminViajes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adminViajes.modelo.entidad.Viaje;
import com.adminViajes.modelo.servicio.ViajeServicio;

@Controller
public class IndexControlador {

	@Autowired
	ViajeServicio viajeServicio;

	@GetMapping("/home")
	public String home(Model modelo) {
		List<Viaje> listadoViajes = viajeServicio.Listado();
		modelo.addAttribute("Viaje", listadoViajes);
		return "index";
	}

}
