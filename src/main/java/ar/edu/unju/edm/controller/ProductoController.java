package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;
//import ar.edu.unju.edm.service.ProductoServiceImp;

@Controller
public class ProductoController {
	
	
	@Autowired
	IProductoService productoService;
	
	@GetMapping("/producto")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", productoService.obtenerProductoNuevo());
		return("producto");
	}

	@PostMapping("/producto")
	public String guardarNuevoProducto( @ModelAttribute ("unProducto") Producto nuevoProducto, Model model) {
		productoService.guardarProducto(nuevoProducto);
		System.out.println(productoService.obtenerTodosProductos().get(0).getMarca());
		model.addAttribute("productos", productoService.obtenerTodosProductos());
		return "resultado";
	}
	
	@GetMapping("/ultimo")
	public String cargarUltimoProducto(Model model) {
		model.addAttribute("ultimoProducto", productoService.obtenerUltimoProducto());
		return("mostrar-ultimo");
	}

	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		//model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return("redirect:/producto");
	}
	
}
