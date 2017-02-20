package ar.com.q3s.market.client.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

@Entity
@XmlRootElement
public class Usuario implements EntityDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	private Long id;
	
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FECHA_ALTA")
	@Type(type="timestamp")
	private Date fechaDeAlta;	
	
	@Column(name = "SEXO")
	private Character sexo;

	@XmlElement(name = "categorias")
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="USUARIO_ID")
	private List<Categoria> categorias;
	
	//-------------------------------------------
	
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public String getFechaDeAltaAsString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(fechaDeAlta);
	}
	
	@Override
	public String toString() {
		return id + "- " + nombre;
	}
	
}