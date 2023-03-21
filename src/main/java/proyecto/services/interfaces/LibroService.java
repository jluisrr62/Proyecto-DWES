package proyecto.services.interfaces;

import java.util.ArrayList;

import proyecto.modelo.Libro;

public interface LibroService {
	public Libro insertarLibro (Libro libro);
	public ArrayList<Libro> listarLibros();
	public Libro obtenerLibroPorId(Integer id);
	public void eliminarLibro(Libro libro);
	public void eliminarLibroPorId(Integer id);
}
