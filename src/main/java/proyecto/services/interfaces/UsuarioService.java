package proyecto.services.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import proyecto.modelo.Usuario;


public interface UsuarioService extends UserDetailsService {
	public Usuario insertarUsuario (Usuario user);
	public List<Usuario> listarUsuarios();
	public Usuario obtenerUsuarioPorId (Integer id);
	public Usuario obtenerUsuarioPorNombre (String nombre);
	public void eliminarUsuario(Usuario user);
	public void eliminarUsuarioPorId(Integer id);
}
