package testbdd1.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.connection.Connection;
import testbdd1.dao.DAO;
import testbdd1.model.Personne;

import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;

public class MainOrmTest {

	private static final int MAX = 100000;

	private static DAO<Personne, String> personneDao;

	private static ConnectionSource conn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "info");
		conn = Connection.getConnection();
		personneDao = new DAO<Personne, String>(conn, Personne.class);
	}

	@Test
	public void test() {
		assertTrue(Connection.initDb());
		int i = 0;
		long deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = new Personne("p" + i);
			p.setNom("nom");
			p.setPrenom("prenom");
			p.setAdresse("adresse");
			personneDao.create(p);
		}
		long fin = System.currentTimeMillis();
		long res1 = fin - deb;
		deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = personneDao.find("p" + i);
			System.out.println(p.toString());
		}
		fin = System.currentTimeMillis();
		System.out.println("Temps insertion : " + res1);
		System.out.println("Temps find : " + (fin - deb));

	}

}
