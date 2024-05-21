package com.adminViajes.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {

	@GetMapping("/api")
	public String home() {
		return "index";
	}

}
