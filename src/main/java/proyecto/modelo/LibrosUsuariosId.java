package proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class LibrosUsuariosId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="libro_id")
	private Integer libroID;
	
	@Column(name="usuario_id")
	private Integer usuarioID;
	
	public LibrosUsuariosId() {
		
	}
	
	public LibrosUsuariosId(Integer idL, Integer idU) {
		this.libroID = idL;
		this.usuarioID = idU;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null || getClass() != o.getClass()) {
			return false;
		}
		LibrosUsuariosId that = (LibrosUsuariosId) o;
		return Objects.equals(libroID, that.libroID)&&
				Objects.equals(usuarioID, that.usuarioID);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(libroID, usuarioID);
	}

	public Integer getLibroID() {
		return libroID;
	}

	public void setLibroID(Integer libroID) {
		this.libroID = libroID;
	}

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
