package proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.modelo.Rol;
import proyecto.modelo.Usuario;
import proyecto.services.impl.RolServiceImpl;
import proyecto.services.impl.UsuarioServiceImpl;



@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl userDetailsService;
	
	@Autowired
	RolServiceImpl rolService;
	
	@GetMapping(value= {"", "/"})
	String homeUsuarios(Model model) {
		
		//salir a buscar a la bd
		List<Usuario> misUsuarios = userDetailsService.listarUsuarios();
		model.addAttribute("listaUsuarios", misUsuarios);
		
		return "usuarios";
	}	
	//controlador para el formulario de registro
	@PostMapping("/addRegistro")
	public String addRegistro(@ModelAttribute("newUser") Usuario usuarioNew, BindingResult bindingresult) {

		usuarioNew.getRoles().add(rolService.obtenerRolPorNombre("ROLE_ADMIN"));
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(usuarioNew.getPassword());
		usuarioNew.setPassword(encodedPassword);
		
		userDetailsService.insertarUsuario(usuarioNew);
			
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("newUser", new Usuario());
		
		return "register";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarUsuario(Model model, @PathVariable Integer id) {
		if(elUsuarioLogueadoEsAdmin()) {
			userDetailsService.eliminarUsuarioPorId(id);
		}
		
		
		return "redirect:/usuarios";
	}
	
	private boolean elUsuarioLogueadoEsAdmin() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		
		if(principal instanceof UserDetails) {
			
			userDetails = (UserDetails) principal;
			
			Usuario u = userDetailsService.obtenerUsuarioPorNombre(userDetails.getUsername());
			
			for(Rol r : u.getRoles()) {
				if(r.getNombre().compareTo("ROLE_ADMIN")==0) {
					return true;
				}
			}
		}
				
		return false;
	}
}
