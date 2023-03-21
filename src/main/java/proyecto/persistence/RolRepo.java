package proyecto.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.modelo.Rol;

public interface RolRepo extends JpaRepository<Rol, Integer>{
	public Rol findByNombre(String nombre);
}
