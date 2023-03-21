package proyecto.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.modelo.Libro;
import proyecto.persistence.LibroRepo;
import proyecto.services.interfaces.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	public LibroRepo libroRepo;

	@Override
	public Libro insertarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepo.save(libro);
	}

	@Override
	public ArrayList<Libro> listarLibros() {
		// TODO Auto-generated method stub
		return (ArrayList<Libro>) libroRepo.findAll();
	}

	@Override
	public Libro obtenerLibroPorId(Integer id) {
		// TODO Auto-generated method stub
		return libroRepo.findById(id).get();
	}

	@Override
	public void eliminarLibro(Libro libro) {
		// TODO Auto-generated method stub
		libroRepo.delete(libro);
	}

	@Override
	public void eliminarLibroPorId(Integer id) {
		// TODO Auto-generated method stub
		libroRepo.delete(libroRepo.findById(id).get());
	}

}
