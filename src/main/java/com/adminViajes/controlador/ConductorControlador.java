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

import com.adminViajes.modelo.entidad.Conductor;
import com.adminViajes.modelo.servicio.ConductorServicio;

@Controller
@RequestMapping("/vistas/Conductor")
public class ConductorControlador {

    @Autowired
    ConductorServicio conductorServicio;

    @GetMapping("/")
    public String listadoConductores(Model modelo) {
        List<Conductor> listadoConductor = conductorServicio.findAll();
        modelo.addAttribute("Conductor", listadoConductor);
        return "/vistas/Conductor/conductores";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
        Conductor conductores = new Conductor();
        modelo.addAttribute("Titulo", "Formulario: Nuevo Conductor");
        modelo.addAttribute("Conductor", conductores);
        return "/vistas/Conductor/registrarConductor";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Conductor conductores, Model modelo) {
        modelo.addAttribute("Titulo:", "Formulario: Nuevo Conductor:");
        modelo.addAttribute("Conductor", conductores);
        return "redirect:/vistas/Conductor/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idConductor, Model modelo) {

        Conductor conductores = new Conductor();

        if (idConductor > 0) {
            conductores = conductorServicio.buscarId(idConductor);
            if (conductores == null) {
                return "redirect:/vistas/Conductor";
            }
        } else {
            return "redirect:/vistas/Conductor";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar Conductor");
        modelo.addAttribute("Conductor", conductores);
        return "/vistas/Conductor/registrarConductor";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idConductor, Model modelo) {

        Conductor conductores = new Conductor();

        if (idConductor > 0) {
            conductores = conductorServicio.buscarId(idConductor);
            if (conductores == null) {
                return "redirect:/vistas/Conductor";
            }
        } else {
            return "redirect:/vistas/Conductor";
        }

        conductorServicio.eliminar(idConductor);
        return "/vistas/Conductor/registrarConductor";
    }

}
