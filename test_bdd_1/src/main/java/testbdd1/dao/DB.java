package testbdd1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	public static String PERSIST_UNIT_NAME = "testjpa";

	// private Object lock;

	public static void open() {
		if (em == null) {
			em = DB.getEm();
			em.getTransaction().begin();
		}
	}

	public synchronized static void close() {
		if (em != null) {
			commit();
			em.close();
			em = null;
		}
	}

	public synchronized static void persist(Object obj) {
		open();
		em.persist(obj);
	}

	public synchronized static void commit() {
		if (em != null) {
			em.getTransaction().commit();
		}
	}

	public static EntityManager getEm() {
		if (emf == null)
			DB.getEmf();
		if (em == null)
			em = emf.createEntityManager();
		return em;
	}

	public static EntityManagerFactory getEmf() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory(PERSIST_UNIT_NAME);
		return emf;
	}

	public synchronized static void reset() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}

	public static void init() {
		reset();
		emf = DB.getEmf();
	}

}
