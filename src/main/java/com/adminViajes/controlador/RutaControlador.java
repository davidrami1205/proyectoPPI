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

import com.adminViajes.modelo.entidad.Ruta;
import com.adminViajes.modelo.servicio.RutaServicio;

@Controller
@RequestMapping("/vistas/Ruta")
public class RutaControlador {

    @Autowired
    RutaServicio rutaServicio;

    @GetMapping("/")
    public String listadoRutas(Model modelo) {
        List<Ruta> listadoRutas = rutaServicio.findAll();
        modelo.addAttribute("Ruta", listadoRutas);
        return "vistas/Ruta/ruta";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
        Ruta rutas = new Ruta();
        modelo.addAttribute("Titulo", "Formulario: Nuevo Vehiculo");
        modelo.addAttribute("Ruta", rutas);
        return "/vistas/Ruta/registrarRuta";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Ruta ruta, Model modelo) {
        modelo.addAttribute("Titulo", "Formulario: Nuevo Vehiculo");
        modelo.addAttribute("Ruta", ruta);
        rutaServicio.save(ruta);
        return "redirect:/vistas/Ruta/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idRuta, Model modelo) {

        Ruta rutas = new Ruta();

        if (idRuta > 0) {
            rutas = rutaServicio.buscarId(idRuta);
            if (rutas == null) {
                return "redirect:/vistas/Ruta/";
            }
        } else {
            return "redirect:/vistas/Ruta/";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar Ruta");
        modelo.addAttribute("Ruta", rutas);
        return "/vistas/Ruta/registrarRuta";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idRuta) {

        Ruta rutas = new Ruta();

        if (idRuta > 0) {
            rutas = rutaServicio.buscarId(idRuta);
            if (rutas == null) {
                return "redirect:/vistas/Ruta";
            }
        } else {
            return "redirect:/vistas/Ruta";
        }

        rutaServicio.eliminar(idRuta);
        return "/vistas/Ruta/registrarRuta";
    }

}
