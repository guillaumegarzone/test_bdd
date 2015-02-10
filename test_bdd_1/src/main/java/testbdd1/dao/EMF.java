package testbdd1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	private static EntityManagerFactory emf;
	public static String PERSIST_UNIT_NAME = "testh2";

	public static EntityManager getEm() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory(PERSIST_UNIT_NAME);

		return emf.createEntityManager();
	}

	public static EntityManagerFactory getEmf() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory(PERSIST_UNIT_NAME);
		return emf;
	}

}
