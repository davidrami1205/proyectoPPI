package com.adminViajes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.UsuarioServicio;

@Controller
@RequestMapping("/vistas")
public class RegistroControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("/registro")
    public String saveUser(@ModelAttribute Usuario usuario, Model modelo) {
        modelo.addAttribute("Titulo", "Formulario: Registrar Usuario");
        modelo.addAttribute("Usuario", usuario);
        usuarioServicio.save(usuario);
        return "redirect:/login";
    }

}
