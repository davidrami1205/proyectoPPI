package com.adminViajes.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.UsuarioServicio;

@Controller
@SessionAttributes("usuario")
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
		return "/vistas/Ruta/registrarUsuario";
	}

}
