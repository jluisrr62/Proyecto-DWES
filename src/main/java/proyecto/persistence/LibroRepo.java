package proyecto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.modelo.Libro;

public interface LibroRepo extends JpaRepository<Libro, Integer> {

}
