package org.restaurante.controller;


import org.restaurante.model.Usuario;
import org.restaurante.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class usuarioController {

	@Autowired
	private IUsuarioRepository repou;
	
	@GetMapping("/login/cargar")
	public String cargarForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	@PostMapping("/login/validar")
	public String validarForm(@ModelAttribute Usuario usuario, Model model) { 
		
		System.out.println(usuario);

		Usuario u = repou.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		System.out.println(u);
	
		if (u == null) {
			
			model.addAttribute("error", "Usuario o clave incorrecto");
			return "login";
		} else {
			model.addAttribute("usuario", u);
			return "principal";
		}

	}
	@GetMapping("/usuario/cargar")
	public String cargarFormRegistrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "registro";
	}

	@PostMapping("/usuario/grabar")
	public String grabarRegistro(@ModelAttribute Usuario usuario, Model model) { // QmodelAtributte sirva para grabar
		
		System.out.println(usuario);
		try {
			repou.save(usuario);
			model.addAttribute("success", "Registro Exitoso");
		} catch (Exception e) {
			model.addAttribute("error", "Error al registrar" + e.getMessage());
		}
		return "registro";
	}
	@GetMapping("/entradas")
	public String Entradas(Model model) {
		System.out.println("entradas");
		return "principal";
	}
	@GetMapping("/sopas")
	public String cargar(Model model) {
		System.out.println("sopas");
		return "interfacesopas";
	}
	@GetMapping("/postres")
	public String cargarPostre(Model model) {
		System.out.println("postres");
		return "postres";
	}
	@GetMapping("/bebidas")
	public String Form(Model model) {
		System.out.println("postres");
		return "bebidas";
	}
}

