package com.adminViajes.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.UsuarioServicio;

@Controller
@RequestMapping("/vistas/Usuario")
public class UsuarioControlador {

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/")
	public String listadoUsuarios(Model modelo) {
		List<Usuario> listadoUsuarios = usuarioServicio.findAll();
		modelo.addAttribute("Usuario", listadoUsuarios);
		return "/vistas/Usuario/usuario";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, Model modelo) {
		modelo.addAttribute("Titulo", "Formulario");
		modelo.addAttribute("Usuario", usuario);
		usuarioServicio.save(usuario);
		return "redirect:/vistas/Usuario";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer idUsuario, Model modelo) {

		Usuario usuarios = new Usuario();

		if (idUsuario > 0) {
			usuarios = usuarioServicio.buscarId(idUsuario);
			if (usuarios == null) {
				return "redirect:/vistas/Usuario/";
			}
		} else {
			return "redirect:/vistas/Usuario";
		}

		modelo.addAttribute("Titulo", "Formulario: Editar Usuario");
		modelo.addAttribute("Usuario", usuarios);
		return "/vistas/Usuario/editarUsuario";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idUsuario) {

		Usuario usuario = new Usuario();

		if (idUsuario > 0) {
			usuario = usuarioServicio.buscarId(idUsuario);
			if (usuario == null) {
				return "redirect:/vistas/Usuario/";
			}
		} else {
			return "redirect:/vistas/Usuario/";
		}

		usuarioServicio.eliminar(idUsuario);
		return "redirect:/vistas/Usuario/";
	}
}
