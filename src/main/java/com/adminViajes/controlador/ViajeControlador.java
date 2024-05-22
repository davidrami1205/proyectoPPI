package com.adminViajes.controlador;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adminViajes.modelo.entidad.Conductor;
import com.adminViajes.modelo.entidad.Ruta;
import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.entidad.Vehiculos;
import com.adminViajes.modelo.entidad.Viaje;
import com.adminViajes.modelo.servicio.ConductorServicio;
import com.adminViajes.modelo.servicio.RutaServicio;
import com.adminViajes.modelo.servicio.UsuarioServicio;
import com.adminViajes.modelo.servicio.VehiculoServicio;
import com.adminViajes.modelo.servicio.ViajeServicio;

@Controller
@RequestMapping("/vistas/Viaje")
public class ViajeControlador {

    @Autowired
    ViajeServicio viajeServicio;
    ConductorServicio conductorServicio;
    RutaServicio rutaServicio;
    VehiculoServicio vehiculoServicio;
    UsuarioServicio usuarioServicio;

    public ViajeControlador(RutaServicio rutaServicio, ConductorServicio conductorServicio,
            UsuarioServicio usuarioServicio, VehiculoServicio vehiculoServicio) {
        this.rutaServicio = rutaServicio;
        this.conductorServicio = conductorServicio;
        this.usuarioServicio = usuarioServicio;
        this.vehiculoServicio = vehiculoServicio;
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idViaje, Model modelo) {

        Viaje viajes = new Viaje();

        if (idViaje > 0) {
            viajes = viajeServicio.buscarId(idViaje);
            if (viajes == null) {
                return "redirect:/home";
            }
        } else {
            return "redirect:/home";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar Viaje");
        modelo.addAttribute("Viaje", viajes);
        return "/vistas/Viaje/registrarViaje";
    }

    @GetMapping("/create")
    public String create(Model modelo) {

        Viaje viajes = new Viaje();

        Iterable<Vehiculos> vehiculos = vehiculoServicio.listaTodos();
        Iterable<Ruta> rutas = rutaServicio.findAll();
        Iterable<Conductor> conductores = conductorServicio.findAll();
        Iterable<Usuario> usuario = usuarioServicio.findAll();

        modelo.addAttribute("Viaje", viajes);
        modelo.addAttribute("Vehiculos", vehiculos);
        modelo.addAttribute("Ruta", rutas);
        modelo.addAttribute("Conductor", conductores);
        modelo.addAttribute("Usuario", usuario);

        return "/vistas/Viaje/registrarViaje";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Viaje viaje, Model modelo) {
        modelo.addAttribute("Titulo", "Formulario: Nuevo Viaje");
        modelo.addAttribute("Viaje", viaje);
        viajeServicio.save(viaje);
        return "redirect:/home";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long idViaje) {

        Viaje viaje = new Viaje();

        if (idViaje > 0) {
            viaje = viajeServicio.buscarId(idViaje);
            if (viaje == null) {
                return "redirect:/home";
            }
        } else {
            return "redirect:/home";
        }

        viajeServicio.eliminar(idViaje);
        return "redirect:/home";
    }

    @PostMapping("/completarViaje/{id}")
    public String completarViaje(@PathVariable("id") Long id, Model model) {
        // Obtener el viaje a completar
        Viaje viaje = viajeServicio.buscarId(id);

        LocalDateTime horaFin = LocalDateTime.now();

        // Calcular la duración del viaje
        LocalDateTime fechaInicio = viaje.getHoraInicio();
        Long segundosTotales = ChronoUnit.SECONDS.between(fechaInicio, horaFin);

        // Convertir segundos totales a Time
        long horas = TimeUnit.SECONDS.toHours(segundosTotales);
        long minutos = TimeUnit.SECONDS.toMinutes(segundosTotales) % 60;
        long segundos = segundosTotales % 60;

        Time duracion = Time.valueOf(String.format("%02d:%02d:%02d", horas, minutos, segundos));

        // Actualizar los campos del viaje
        viaje.setHoraFin(horaFin);
        viaje.setDuracion(duracion);
        String estado = "FINALIZADO";
        viaje.setEstado(estado);

        // Guardar los cambios en el viaje
        viajeServicio.save(viaje);

        // Redirigir a alguna página de confirmación o mostrar un mensaje de éxito
        return "redirect:/home";
    }
}
