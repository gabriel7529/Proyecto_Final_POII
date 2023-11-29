package org.restaurante.controller;


import org.restaurante.model.Entradas;
import org.restaurante.model.Lacteos;
import org.restaurante.model.Postres;
import org.restaurante.model.Sopas;
import org.restaurante.repository.IEntradasRepository;
import org.restaurante.repository.ILacteosRepository;
import org.restaurante.repository.IPostresRepository;
import org.restaurante.repository.ISopasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class platosContoller {

	@Autowired
	private IEntradasRepository repoe;
	@Autowired
	private ISopasRepository repos;
	@Autowired
	private ILacteosRepository repol;
	@Autowired
	private IPostresRepository repop;
	
	
	
	@GetMapping("/listar/sopas")
	public String listaSopas(Model model) {
	
		model.addAttribute("lstSopas", repos.findAll());
		return "listaSopas"; 
	}
	@GetMapping("/listar/entradas")
	public String listaEntrad(Model model) {
	
		model.addAttribute("lstEntradas", repoe.findAll());
		return "listaEntradas"; 
	}
	@GetMapping("/listar/lacteos")
	public String listaLacteos(Model model) {
	
		model.addAttribute("lstLacteos", repol.findAll());
		return "listaLacteos"; 
	}
	@GetMapping("/listar/postres")
	public String listaPostres(Model model) {
	
		model.addAttribute("lstPostres", repop.findAll());
		return "listaPostres"; 
	}
	
	
	@PostMapping("/sopas/consultar")
	public String buscarSopa(@ModelAttribute Sopas s, Model model) { 
		
		System.out.println(s);
		model.addAttribute("sopas",repos.findById(s.getId_sopa()));
		
		return "consultaSopas";
	}
	
	@PostMapping("/entrada/consultar")
	public String buscarEntrada(@ModelAttribute Entradas e, Model model) { 
		
		System.out.println(e);
		model.addAttribute("entradas",repoe.findById(e.getId_entrada()));
		
		return "consultaEntradas"; 
	}
	
	@PostMapping("/lacteos/consultar")
	public String buscarLacteo(@ModelAttribute Lacteos l, Model model) { 
		
		System.out.println(l);
		model.addAttribute("lacteos",repol.findById(l.getId_lacteo()));
		
		return "consultaLacteos"; 
	}
	
	@PostMapping("/postres/consultar")
	public String buscarPostre(@ModelAttribute Postres p, Model model) { 
		
		System.out.println(p);
		model.addAttribute("postres",repop.findById(p.getId_postres()));
		return "consultaPostres";
	}
	
	
	
}
