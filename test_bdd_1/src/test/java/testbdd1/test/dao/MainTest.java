package testbdd1.test.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.Test;

import testbdd1.dao.DaoPersonne;
import testbdd1.dao.EMF;
import testbdd1.dao.PersonneDAO;
import testbdd1.model.Personne;

public class MainTest {

	private static final int MAX1 = 100;

	private static final int MAX2 = 1000;

	private static final int MAX3 = 10000;

	@Test
	public void testJpa() throws SQLException {
		test(MAX1);
		test(MAX2);
		test(MAX3);
	}

	public static void test(int MAX) throws SQLException {
		long deb, fin;
		deb = System.currentTimeMillis();
		EMF.reset();
		// PersonneDAO personneDao = new PersonneDAO(EMF.getEmf());
		DaoPersonne personneDao = new DaoPersonne();
		EMF.getEmf();
		// conn = ConnectionH2.getConnection();
		// assertTrue(ConnectionH2.initDb());
		// EntityManager em = EMF.getEm();
		// em.close();
		fin = System.currentTimeMillis();
		// personneDao = new DAO<Personne, Integer>(conn, Personne.class);
		long init = fin - deb;

		int i = 1;
		deb = System.currentTimeMillis();
		for (i = 1; i <= MAX; i++) {
			Personne p = new Personne(i);
			p.setNom("nom-" + "i");
			p.setPrenom("prenom-");
			p.setAdresse("adresse-");
			// if (i == MAX)
			personneDao.create(p);
			// else
			// personneDao.lazyCreate(p);
		}
		personneDao.endTransaction();
		// EMF.getEm().getTransaction().commit();
		// EMF.getEm().close();
		fin = System.currentTimeMillis();
		long insert = fin - deb;
		deb = System.currentTimeMillis();
		for (i = 1; i <= MAX; i++) {
			Personne p2 = personneDao.find(i);
			assertNotNull(p2);
			// System.out.println(p2.toString());
		}
		fin = System.currentTimeMillis();
		long find = fin - deb;

		System.out.println("Temps init : " + init);
		System.out.println("Temps " + MAX + " insertion : " + insert);
		System.out.println("Temps find : " + find);

	}
}
