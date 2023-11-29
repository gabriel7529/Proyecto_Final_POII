package org.restaurante.controller;

import java.util.Optional;

import org.restaurante.model.Compra;
import org.restaurante.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class compraController {

	@Autowired
	private ICompraRepository repocompra;
	private Optional<Compra> compraOptional;
	
	
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
	
	@GetMapping("/compra/validarCart")
	public String RegistraCompraCart(@RequestParam(name = "idPlato", required = true) String idProducto,
            @RequestParam(name = "cantidad", required = true) int cantidad,
            Model model) {
		
		Compra compra = new Compra();
        compra.setDes_compra(idProducto); 
        compra.setCant_compra(cantidad);
		repocompra.save(compra);
        
        return "redirect:/compra/listar";
	}
	
	@GetMapping("/compra/listar")
	public String cargarLista(Model model) {
		model.addAttribute("lstCompras", repocompra.findAll());
		return "listaDeCompras";
	}
	@GetMapping("/compra/pagar")
	public String pago(@RequestParam(name = "idCompra", required = true) int idCompra, Model model) {
		compraOptional = repocompra.findById(idCompra);
		if (compraOptional.isPresent()) {
	        Compra compra = new Compra();
	        compra.setDes_compra(compraOptional.get().getDes_compra());
	        compra.setId_compra(compraOptional.get().getId_compra());
	        compra.setCant_compra(compraOptional.get().getCant_compra());
	        repocompra.deleteById(idCompra);
	        model.addAttribute("compra", compra);
	        return "pago";
	    } else {
	        
	        model.addAttribute("error", "La compra con ID " + idCompra + " no existe");
	        return "error";  
	    }
	
	}
}
