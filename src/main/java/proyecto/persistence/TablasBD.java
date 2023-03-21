package proyecto.persistence;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import proyecto.modelo.Libro;
import proyecto.modelo.LibrosUsuarios;
import proyecto.modelo.Rol;
import proyecto.modelo.Usuario;

public class TablasBD {
	public void crearTablas() {
		
		GenericDAO<LibrosUsuarios> DAOlu = new GenericDAO<LibrosUsuarios>(LibrosUsuarios.class);

		Libro mates = new Libro("1234565A", "matematicas");
		Libro lengua = new Libro("456123C", "lengua");

		Usuario jorjito = new Usuario("jorjito", "jorjon96", "1234");
		Usuario luis = new Usuario("Luis", "Luisito47", "1234");

		GenericDAO<Rol> DAOr = new GenericDAO<Rol>(Rol.class);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Rol admin = new Rol("ROLE_ADMIN");
		Rol user = new Rol("ROLE_USER");
		
		String encodedPassword = encoder.encode(jorjito.getPassword());
		
		jorjito.setPassword(encodedPassword);
		
		encodedPassword = encoder.encode(luis.getPassword());
		
		luis.setPassword(encodedPassword);
		
		admin.getUsuarios().add(luis);
		luis.getRoles().add(admin);
		
		user.getUsuarios().add(jorjito);
		jorjito.getRoles().add(user);
		

		DAOr.insertarRegistroJPA(admin);
		DAOr.insertarRegistroJPA(user);
		
		LibrosUsuarios matesYjorjito = new LibrosUsuarios(mates, jorjito, 3);
		LibrosUsuarios lenguaYluis = new LibrosUsuarios(lengua, luis, 2);
		
		mates.getLibrosUsuarios().add(matesYjorjito);
		jorjito.getLibrosUsuarios().add(matesYjorjito);
		lengua.getLibrosUsuarios().add(lenguaYluis);
		luis.getLibrosUsuarios().add(lenguaYluis);

		DAOlu.insertarRegistroJPA(lenguaYluis);
		DAOlu.insertarRegistroJPA(matesYjorjito);


		

		
	}

	
	
}
