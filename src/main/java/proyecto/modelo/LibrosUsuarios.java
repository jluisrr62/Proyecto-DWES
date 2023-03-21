package proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="libros_usuarios")
public class LibrosUsuarios {

	@EmbeddedId
	private LibrosUsuariosId id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("libroID")
	@JoinColumn(name="libro_id")
	private Libro libro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("usuarioID")
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@Column(name="cantidad")
	private int cantidad;

	public LibrosUsuarios(Libro l, Usuario u, int cantidad) {
		this.libro = l;
		this.usuario = u;
		this.cantidad = cantidad;
		this.id = new LibrosUsuariosId(l.getId(), u.getId());
	}

	public LibrosUsuarios() {
		
	}
	


	public LibrosUsuariosId getId() {
		return id;
	}

	public void setId(LibrosUsuariosId id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
