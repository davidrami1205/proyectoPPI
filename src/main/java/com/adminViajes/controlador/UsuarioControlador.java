package com.adminViajes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioControlador {

	@Autowired
	private IUsuarioService usuarioServicio;

	@PostMapping("/api/users")
	public String crearUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
		// Procesa la creación de un nuevo usuario usando los datos recibidos del
		// formulario
		usuarioServicio.save(usuario);

		// Agrega un mensaje de éxito para mostrar al usuario
		redirectAttributes.addFlashAttribute("mensaje", "¡Usuario creado exitosamente! Por favor, inicia sesión.");

		// Redirige al usuario a la página de inicio de sesión
		return "redirect:/login";
	}

	@PostMapping("/api/comprobar/")
	public String comprobarLogin(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena,
			Model modelo) {

		Usuario usuario = usuarioServicio.buscarCorreo(correo);

		if (usuario == null) {
			System.out.println("usuario no encontrado");
			modelo.addAttribute("error", "Usuario o Contraseña Incorrecta");
			return "redirect:/login";
		}

		System.out.println("Contraseña almacenada: " + usuario.getContrasena());
		if (!usuario.getContrasena().equals(contrasena)) {
			System.out.println("Contraseña incorrecta");
			modelo.addAttribute("error", "Usuario o Contraseña Incorrecta");
			return "redirect:/login";
		}

		System.out.println("Inicio de sesión exitoso");

		return "redirect:/";
	}

}
