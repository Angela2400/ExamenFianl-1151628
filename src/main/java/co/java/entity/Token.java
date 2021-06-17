package co.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String host;
	@Column
	String userdb;
	@Column
	String pass;
	@Column
	String db;
	@Column
	String token;
	@Column
	Integer port;
	
	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "user")
	Usuario user;
	
	@Column
	Integer state;
	
	@ManyToOne
	@JoinColumn(name = "type", referencedColumnName = "type")
	TipoDB type;

	public Token(String host, String userdb, String pass, String db, String token, Integer port, Usuario user,
			Integer state, TipoDB type) {
		super();
		this.host = host;
		this.userdb = userdb;
		this.pass = pass;
		this.db = db;
		this.token = token;
		this.port = port;
		this.user = user;
		this.state = state;
		this.type = type;
	}

	public Token(Integer id, String host, String userdb, String pass, String db, String token, Integer port,
			Usuario user, Integer state, TipoDB type) {
		super();
		this.id = id;
		this.host = host;
		this.userdb = userdb;
		this.pass = pass;
		this.db = db;
		this.token = token;
		this.port = port;
		this.user = user;
		this.state = state;
		this.type = type;
	}

	public Token() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserdb() {
		return userdb;
	}

	public void setUserdb(String userdb) {
		this.userdb = userdb;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public TipoDB getType() {
		return type;
	}

	public void setType(TipoDB type) {
		this.type = type;
	}
	
	
}
