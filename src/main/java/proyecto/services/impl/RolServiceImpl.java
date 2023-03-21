package proyecto.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.modelo.Rol;
import proyecto.persistence.RolRepo;
import proyecto.services.interfaces.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	public RolRepo rolRepo;
	
	@Override
	public Rol obtenerRolPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Rol rol = rolRepo.findByNombre(nombre);
		
		return rol;
	}

}
