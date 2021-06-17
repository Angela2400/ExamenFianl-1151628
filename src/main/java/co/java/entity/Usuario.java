package co.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String usuario;
	
	@Column
	String email;
	
	@Column
	String pass;
	
	@ManyToOne
	@JoinColumn(name = "role", referencedColumnName = "role")
	Rol rol;
	
	@Column
	Integer state;
	
	@OneToMany
	List<Token> tokens;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String usuario, String email, String pass, Rol rol, Integer state) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.pass = pass;
		this.rol = rol;
		this.state = state;
	}

	public Usuario(String usuario, String email, String pass, Rol rol, Integer state) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.pass = pass;
		this.rol = rol;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
