package org.restaurante.controller;

import java.util.List;

import org.restaurante.model.Entradas;
import org.restaurante.model.Lacteos;
import org.restaurante.model.Postres;
import org.restaurante.model.Sopas;
import org.restaurante.model.Usuario;
import org.restaurante.repository.IEntradasRepository;
import org.restaurante.repository.ILacteosRepository;
import org.restaurante.repository.IPostresRepository;
import org.restaurante.repository.ISopasRepository;
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

	@Autowired
	private IEntradasRepository repoe;

	@Autowired
	private ISopasRepository repos;

	@Autowired
	private IPostresRepository repop;

	@Autowired
	private ILacteosRepository repob;

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
		List<Entradas> listaEntradas = repoe.findAll();

		model.addAttribute("listaEntradas", listaEntradas);
		System.out.println("entradas");
		return "principal";
	}

	@GetMapping("/sopas")
	public String cargar(Model model) {
		List<Sopas> listaSopas = repos.findAll();

		// Agregar la lista al modelo
		model.addAttribute("listaSopas", listaSopas);
		System.out.println("sopas");
		return "interfacesopas";
	}

	@GetMapping("/postres")
	public String cargarPostre(Model model) {
		List<Postres> listaPostres = repop.findAll();

		// Agregar la lista al modelo
		model.addAttribute("listaPostres", listaPostres);
		System.out.println("postres");
		return "postres";
	}

	@GetMapping("/bebidas")
	public String Form(Model model) {
		List<Lacteos> listaBebidas = repob.findAll();
		model.addAttribute("listaBebidas", listaBebidas);
		System.out.println("postres");
		return "bebidas";
	}
}
