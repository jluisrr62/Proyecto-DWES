package proyecto.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="ISBN")
	private String ISBN;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy="libro", fetch = FetchType.EAGER)
	private Set<LibrosUsuarios> librosUsuarios;
	
	
	public Libro(String ISBN, String nombre) {
		this.ISBN = ISBN;
		this.nombre = nombre;
		this.librosUsuarios= new HashSet<LibrosUsuarios>();
	}
	
	public Libro() {
		
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<LibrosUsuarios> getLibrosUsuarios() {
		return librosUsuarios;
	}

	public void setLibrosUsuarios(Set<LibrosUsuarios> librosUsuarios) {
		this.librosUsuarios = librosUsuarios;
	}
	
	
	
}
