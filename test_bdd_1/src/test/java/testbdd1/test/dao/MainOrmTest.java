package testbdd1.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.connection.ConnectionH2;
import testbdd1.connection.ConnectionSqlite;
import testbdd1.dao.DAO;
import testbdd1.model.Personne;

import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;

public class MainOrmTest {

	private static final int MAX = 1000;

	private static DAO<Personne, Integer> personneDao;

	private static ConnectionSource conn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	// @Test
	// public void global() throws SQLException {
	// ConnectionSource conn = ConnectionSqlite.getConnection();
	// test(conn);
	// conn.close();
	//
	// conn = ConnectionH2.getConnection();
	// test(conn);
	// conn.close();
	// }

	@Test
	public void test2() throws SQLException {
		long deb, fin;
		conn = ConnectionSqlite.getConnection();
		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "info");

		deb = System.currentTimeMillis();
		assertTrue(ConnectionSqlite.initDb());
		fin = System.currentTimeMillis();
		personneDao = new DAO<Personne, Integer>(conn, Personne.class);
		long init = fin - deb;

		int i = 125467864;
		deb = System.currentTimeMillis();
		// for (i = 1; i <= MAX; i++) {
		// Personne p = new Personne(i);
		// p.setNom("nom");
		// p.setPrenom("prenom");
		// p.setAdresse("adresse");
		// personneDao.create(p);
		// }
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
		System.out.println("Temps insertion : " + insert);
		System.out.println("Temps find : " + find);

		ConnectionSqlite.closeConnection();

	}

	@Test
	public void test() throws SQLException {
		long deb, fin;
		conn = ConnectionH2.getConnection();
		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "info");

		deb = System.currentTimeMillis();
		assertTrue(ConnectionH2.initDb());
		fin = System.currentTimeMillis();
		personneDao = new DAO<Personne, Integer>(conn, Personne.class);
		long init = fin - deb;

		int i = 125467864;
		deb = System.currentTimeMillis();
		for (i = 1; i <= MAX; i++) {
			Personne p = new Personne(i);
			p.setNom("nom");
			p.setPrenom("prenom");
			p.setAdresse("adresse");
			personneDao.create(p);
		}
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
		System.out.println("Temps insertion : " + insert);
		System.out.println("Temps find : " + find);

		ConnectionH2.closeConnection();

	}

}
