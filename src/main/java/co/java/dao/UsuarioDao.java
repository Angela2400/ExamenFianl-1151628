package co.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.java.entity.Usuario;
import co.java.util.ConexionJPA;

public class UsuarioDao {
private EntityManager em;
	
	public UsuarioDao() {
		em = ConexionJPA.getEntityManagerFactory().createEntityManager();
	}
	
	public void createUser(Usuario user) {
    	em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

public void updateUser(Usuario user) {
	em.getTransaction().begin();
	em.merge(user);
	em.getTransaction().commit();
}

public void deleteUser(int id) {

	Usuario user = new Usuario();
	user = em.find(Usuario.class, id);
	em.getTransaction().begin();
	em.remove(user);
	em.getTransaction().commit();
}


public Usuario getUser(int id) {

	Usuario user = new Usuario();
	user = em.find(Usuario.class, id);
    return user;
}

/**
 * Get all Users
 * @return
 */

public List<Usuario> getUsers() {
	List<Usuario> listaUsuario = new ArrayList<>();
	Query q = em.createQuery("SELECT u FROM Usuario u");
	listaUsuario = q.getResultList();
	return listaUsuario;
}
}
