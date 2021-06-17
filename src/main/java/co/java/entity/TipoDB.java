package co.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String descripcion;
	
	@Column
	String driver;
	
	@Column
	String adicional;
	
	@OneToMany
	List<Token> tokens;

	public TipoDB() {
		super();
	}

	public TipoDB(String descripcion, String driver, String adicional, List<Token> tokens) {
		super();
		this.descripcion = descripcion;
		this.driver = driver;
		this.adicional = adicional;
		this.tokens = tokens;
	}

	public TipoDB(Integer id, String descripcion, String driver, String adicional, List<Token> tokens) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.driver = driver;
		this.adicional = adicional;
		this.tokens = tokens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	
}
