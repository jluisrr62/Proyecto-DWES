package proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.modelo.Libro;
import proyecto.services.impl.LibroServiceImpl;

@RequestMapping("/")
@Controller
public class LibrosController {

	@Autowired
	LibroServiceImpl libroService;
	
	@GetMapping(value={"/",""})
	String homeLibros(Model model) {
		
		ArrayList<Libro> misLibros = (ArrayList<Libro>) libroService.listarLibros();
		
		model.addAttribute("listaLibros", misLibros);
		
		
		return "libros";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarLibro(Model model, @PathVariable Integer id) {
	
		libroService.eliminarLibro(libroService.obtenerLibroPorId(id));
		
		return "redirect:/";
	}
	
}
