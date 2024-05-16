package com.adminViajes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adminViajes.modelo.entidad.Vehiculos;
import com.adminViajes.modelo.servicio.IVehiculoServicio;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/vistas/Vehiculos")
public class VehiculoControlador {

	@Autowired
	private IVehiculoServicio vehiculoServicio;

	@GetMapping("/")
	public String listadoVehiculos(Model modelo) {
		List<Vehiculos> listadoVehiculos = vehiculoServicio.listaTodos();
		modelo.addAttribute("Vehiculos", listadoVehiculos);
		return "/vistas/Vehiculos/vehiculos";
	}

	@GetMapping("/create")
	public String crear(Model modelo) {
		// Crear el objeto
		Vehiculos vehiculos = new Vehiculos();

		modelo.addAttribute("Titulo", "Formulario Nuevo Contacto");
		modelo.addAttribute("Vehiculos", vehiculos);
		return "/vistas/Vehiculos/registrarVehiculos";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Vehiculos vehiculos, Model modelo) {
		modelo.addAttribute("Titulo", "Formulario: Nuevo Vehiculo");
		modelo.addAttribute("Vehiculos", vehiculos);
		// Utilizar el servicio para almacenar en la BD
		vehiculoServicio.guardar(vehiculos);
		return "redirect:/vistas/Vehiculos/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idVehiculo, Model modelo) {

		Vehiculos vehiculos = new Vehiculos();
		// Validar si el Id existe
		if (idVehiculo > 0) {
			vehiculos = vehiculoServicio.buscarPorId(idVehiculo);
			if (vehiculos == null) {
				return "redirect:/vistas/Vehiculos/";
			}
		} else {
			return "redirect:/vistas/Vehiculos/";
		}

		modelo.addAttribute("Titulo", "Formulario: Editar Contacto");
		modelo.addAttribute("Vehiculos", vehiculos);
		return "/vistas/Vehiculos/registrarVehiculos";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idVehiculo) {

		Vehiculos vehiculos = new Vehiculos();

		if (idVehiculo > 0) {
			vehiculos = vehiculoServicio.buscarPorId(idVehiculo);
			if (vehiculos == null) {
				return "redirect:/vistas/Vehiculos/";
			}
		} else {
			return "redirect:/vistas/Vehiculos/";
		}

		// invocar el servicio para eliminar
		vehiculoServicio.eliminar(idVehiculo);
		return "redirect:/vistas/Vehiculos/";
	}
}
