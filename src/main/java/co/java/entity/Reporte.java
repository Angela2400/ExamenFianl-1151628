package co.java.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jdk.jfr.Timestamp;

@Entity
public class Reporte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String file;
	
	@ManyToOne
	@JoinColumn(name = "conexion", referencedColumnName = "conexion")
	Token token;
	
	@Column
	String dataCreate;
	
	@Column
	String state;
	
	@Column
	String description;
	
	@Column
	String name;

	public Reporte() {
		super();
	}

	public Reporte(Integer id, String file, Token token, String dataCreate, String state, String description,
			String name) {
		super();
		this.id = id;
		this.file = file;
		this.token = token;
		this.dataCreate = dataCreate;
		this.state = state;
		this.description = description;
		this.name = name;
	}

	public Reporte(String file, Token token, String dataCreate, String state, String description, String name) {
		super();
		this.file = file;
		this.token = token;
		this.dataCreate = dataCreate;
		this.state = state;
		this.description = description;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getDataCreate() {
		return dataCreate;
	}

	public void setDataCreate(String dataCreate) {
		this.dataCreate = dataCreate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
