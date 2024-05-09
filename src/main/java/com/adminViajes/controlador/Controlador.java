package com.adminViajes.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminViajes.modelo.entidad.Vehiculos;
import com.adminViajes.modelo.servicio.IVehiculoServicio;

@Controller
@RequestMapping("/vistas/vehiculos")
public class Controlador {
	
	@Autowired
	private IVehiculoServicio vehiculoServicio;
	
	@GetMapping("/listar")
	public String listadoVehiculos(Model modelo) {
		List<Vehiculos> listadoVehiculos=vehiculoServicio.listaTodos();
		modelo.addAttribute("vehiculos",listadoVehiculos);
		return "/vistas/vehiculos/listarVehiculos";
	}
	
}
