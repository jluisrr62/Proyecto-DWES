package proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import proyecto.modelo.Rol;
import proyecto.modelo.Usuario;
import proyecto.persistence.RolRepo;
import proyecto.persistence.UsuarioRepo;
import proyecto.services.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepo usuarioRepo;
	@Autowired
	private RolRepo rolRepo;
	
	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Usuario> usuario = usuarioRepo.findByUsername(username);
		
		if(usuario.isPresent()) {
			Usuario springUsermio = usuario.get();
			return springUsermio;
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

	@Override
	public Usuario insertarUsuario(Usuario user) {
		
		return usuarioRepo.save(user);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		
		return usuarioRepo.findById(id).get();
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String nombre) {

		return usuarioRepo.findByUsername(nombre).get();
	}

	@Override
	public void eliminarUsuario(Usuario user) {

		usuarioRepo.delete(user);
	}

	@Override
	public void eliminarUsuarioPorId(Integer id) {
		
		usuarioRepo.delete(usuarioRepo.findById(id).get());
	}

		//crear roles
	public void crearRoles() {
		Rol admin = new Rol("ROL_ADMIN");
		Rol user = new Rol("ROL_USER");
		rolRepo.save(admin);
		rolRepo.save(user);
	}
		
	
}
