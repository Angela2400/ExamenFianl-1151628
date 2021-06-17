package co.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.java.entity.Token;
import co.java.util.ConexionJPA;

public class TokenDao {
private EntityManager em;
	
	public TokenDao() {
		em = ConexionJPA.getEntityManagerFactory().createEntityManager();
	}
	
	public void createToken(Token token) {
    	em.getTransaction().begin();
		em.persist(token);
		em.getTransaction().commit();
	}

public void updateToken(Token token) {
	em.getTransaction().begin();
	em.merge(token);
	em.getTransaction().commit();
}

public void deleteToken(int id) {

	Token token = new Token();
	token = em.find(Token.class, id);
	em.getTransaction().begin();
	em.remove(token);
	em.getTransaction().commit();
}


public Token getToken(int id) {

	Token token = new Token();
	token = em.find(Token.class, id);
    return token;
}

/**
 * Get all Users
 * @return
 */

public List<Token> getTokens() {
	List<Token> listaTokens = new ArrayList<>();
	Query q = em.createQuery("SELECT t FROM Token t");
	listaTokens = q.getResultList();
	return listaTokens;
}
}
