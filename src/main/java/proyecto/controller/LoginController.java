package proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@GetMapping(value= {"", "/"})
	String login() {
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		
		
		return "login";
	}

}