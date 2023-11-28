package org.restaurante.controller;

import org.restaurante.model.Compra;

import org.restaurante.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class compraController {

	@Autowired
	private ICompraRepository repocompra;
	
	
	@GetMapping("/compra/cargar")
	public String cargarForm(Compra c,Model model) {
		model.addAttribute("compra", new Compra());
		
		return "compra";
	}
	@PostMapping("/compra/validar")
	public String RegistraCompra(@ModelAttribute Compra compra,Model model) {
		System.out.println(compra);
		
		try {
			repocompra.save(compra);
			model.addAttribute("success", "Compra Exitoso");
		} catch (Exception e) {
			model.addAttribute("error", "Error al registrar su compra" + e.getMessage());
		}
		return "compra";
	}
	@GetMapping("/compra/listar")
	public String cargarLista(Model model) {
		model.addAttribute("lstCompras", repocompra.findAll());
		return "listaDeCompras";
	}
	@GetMapping("/compra/pagar")
	public String pago(Model model) {
		model.addAttribute("compra", new Compra());
		return "pago";
	}
}
