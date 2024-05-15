package com.adminViajes.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adminViajes.modelo.entidad.Viaje;
import com.adminViajes.modelo.servicio.ViajeServicio;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/index")
public class ViajeControlador {

    @Autowired
    ViajeServicio viajeServicio;

    @GetMapping("/")
    public String listaViajes(Model modelo) {
        List<Viaje> Listaviajes = viajeServicio.findAll();
        modelo.addAttribute("Viaje", Listaviajes);
        return "index";
    }

}
