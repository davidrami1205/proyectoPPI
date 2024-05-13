package com.adminViajes.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adminViajes.modelo.entidad.Viaje;
import com.adminViajes.modelo.servicio.ViajeServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class ViajeControlador {

    @Autowired
    ViajeServicio viajeServicio;

    @GetMapping("/lista")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index/lista");
        List<Viaje> viaje = viajeServicio.findAll();
        mv.addObject("viaje", viaje);
        return mv;
    }

}
