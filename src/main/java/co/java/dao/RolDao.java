package co.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.java.entity.Rol;
import co.java.util.ConexionJPA;

public class RolDao {
private EntityManager em;
	
	public RolDao() {
		em = ConexionJPA.getEntityManagerFactory().createEntityManager();
	}
	
	public void createUser(Rol rol) {
    	em.getTransaction().begin();
		em.persist(rol);
		em.getTransaction().commit();
	}

public void updateUser(Rol rol) {
	em.getTransaction().begin();
	em.merge(rol);
	em.getTransaction().commit();
}

public void deleteUser(int id) {

	Rol user = new Rol();
	user = em.find(Rol.class, id);
	em.getTransaction().begin();
	em.remove(user);
	em.getTransaction().commit();
}


public Rol getUser(int id) {

	Rol user = new Rol();
	user = em.find(Rol.class, id);
    return user;
}

/**
 * Get all Users
 * @return
 */

public List<Rol> getUsers() {
	List<Rol> listaUsuarios = new ArrayList<>();
	Query q = em.createQuery("SELECT u FROM Rol u");
	listaUsuarios = q.getResultList();
	return listaUsuarios;
}
}
