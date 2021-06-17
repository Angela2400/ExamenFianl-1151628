package co.java.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
private static final String  persistencia = "Examen_1151628";
	
	//Conexion a la base de datos mediante EMF
	private static EntityManagerFactory emf;
	
	private static EntityManager em;
	
	public static EntityManager getEntityManager() {
		em = emf.createEntityManager();
		return em;
	}
	
	//Obtener la conexion; si es null la crea
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf==null) {
			emf = Persistence.createEntityManagerFactory(persistencia);
		}
		return emf;
	}
	
	//Cerrar la conexion
	public void cerrarConexion() {
		if(emf!=null) {
			emf.close();
		}
	}
}
