package co.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.java.entity.Reporte;
import co.java.entity.Token;
import co.java.util.ConexionJPA;

public class ReporteDao {
private EntityManager em;
	
	public ReporteDao() {
		em = ConexionJPA.getEntityManagerFactory().createEntityManager();
	}
	
	public void createReporte(Reporte reporte) {
    	em.getTransaction().begin();
		em.persist(reporte);
		em.getTransaction().commit();
	}

public void updateReporte(Reporte reporte) {
	em.getTransaction().begin();
	em.merge(reporte);
	em.getTransaction().commit();
}

public void deleteReporte(int id) {

	Reporte reporte = new Reporte();
	reporte = em.find(Reporte.class, id);
	em.getTransaction().begin();
	em.remove(reporte);
	em.getTransaction().commit();
}


public Reporte getReporte(int id) {

	Reporte reporte = new Reporte();
	reporte = em.find(Reporte.class, id);
    return reporte;
}

/**
 * Get all Users
 * @return
 */

public List<Reporte> getReportes() {
	List<Reporte> listaReportes = new ArrayList<>();
	Query q = em.createQuery("SELECT r FROM Reporte r");
	listaReportes = q.getResultList();
	return listaReportes;
}
}
