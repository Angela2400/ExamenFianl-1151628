package co.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.java.entity.TipoDB;
import co.java.util.ConexionJPA;

public class TipoDBDao {
private EntityManager em;
	
	public TipoDBDao() {
		em = ConexionJPA.getEntityManagerFactory().createEntityManager();
	}
	
	public void createTipo(TipoDB tipo) {
    	em.getTransaction().begin();
		em.persist(tipo);
		em.getTransaction().commit();
	}

public void updateRol(TipoDB tipo) {
	em.getTransaction().begin();
	em.merge(tipo);
	em.getTransaction().commit();
}

public void deleteRol(int id) {

	TipoDB tipo = new TipoDB();
	tipo = em.find(TipoDB.class, id);
	em.getTransaction().begin();
	em.remove(tipo);
	em.getTransaction().commit();
}


public TipoDB getRol(int id) {

	TipoDB tipo = new TipoDB();
	tipo = em.find(TipoDB.class, id);
    return tipo;
}

/**
 * Get all Users
 * @return
 */

public List<TipoDB> getTipoDB() {
	List<TipoDB> listaTipo= new ArrayList<>();
	Query q = em.createQuery("SELECT tdb FROM TipoDB tdb");
	listaTipo = q.getResultList();
	return listaTipo;
}
}
