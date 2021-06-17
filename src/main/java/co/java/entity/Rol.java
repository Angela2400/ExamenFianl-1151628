package co.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String description;
	
	@OneToMany
	List<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Rol(Integer id, String description, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.description = description;
		this.usuarios = usuarios;
	}

	public Rol(String description, List<Usuario> usuarios) {
		super();
		this.description = description;
		this.usuarios = usuarios;
	}

	public Rol() {
		super();
	}
	
	
	
}
