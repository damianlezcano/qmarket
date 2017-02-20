package ar.com.q3s.market.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Categoria implements EntityDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CATEGORIA_ID")
	private Long id;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "NOTIFICADO")
	private Boolean notificado = false;
	
	//-------------------------------------------
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getNotificado() {
		return notificado;
	}

	public void setNotificado(Boolean notificado) {
		this.notificado = notificado;
	}
	
	public String toString() {
		return descripcion;
	}
	
}