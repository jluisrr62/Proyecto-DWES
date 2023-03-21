package proyecto.persistence;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import proyecto.util.JPAUtil;




public class GenericDAO<T> {
private Class<T> claseDelRegistro;
	
	
	
	public GenericDAO(Class<T> miClase) {
		claseDelRegistro = miClase;
	}
	
	
	public void insertarRegistroJPA(T a) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	

	public void modificarRegistroJPA(T a) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void deleteRegistroJPA(T a) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(a) ? a : em.merge(a));
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public ArrayList<T> listarRegistrosJPA(String tabla) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin();

			ArrayList<T> misRegistros = (ArrayList<T>) em.createQuery("from "+tabla).getResultList();

			em.getTransaction().commit();
			return misRegistros;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

		return null;
	}

	public T buscarPorIdJPA(int i) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			T registro = em.find(claseDelRegistro, i);
			System.out.println("El registro buscado se llama " + registro);
			return registro;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

		return null;
	}
}
