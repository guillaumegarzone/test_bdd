package testbdd1.test.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.connection.Connection;
import testbdd1.dao.DAO;
import testbdd1.model.Personne;

import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;

public class MainOrmTest {

	private static final int MAX = 1000000;

	private static DAO<Personne, String> personneDao;

	private static ConnectionSource conn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	// @Test
	public void global() throws SQLException {
		int i = 0;
		for (i = 0; i < 10; i++) {
			// new Thread() {
			// @Override
			// public void run() {
			// try {
			test();
			// } catch (SQLException e) {
			// e.printStackTrace();
			// }
			// };
			// }.start();

		}
	}

	@Test
	public void test() throws SQLException {
		long deb, fin;

		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "info");

		deb = System.currentTimeMillis();
		conn = Connection.getConnection();
		assertTrue(Connection.initDb());
		fin = System.currentTimeMillis();
		personneDao = new DAO<Personne, String>(conn, Personne.class);
		long init = fin - deb;

		int i = 0;
		deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = new Personne(i);
			p.setNom("nom");
			p.setPrenom("prenom");
			p.setAdresse("adresse");
			personneDao.create(p);
		}
		fin = System.currentTimeMillis();
		long insert = fin - deb;
		deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = personneDao.find("p" + i);
			// System.out.println(p.toString());
		}
		fin = System.currentTimeMillis();
		long find = fin - deb;
		System.out.println("Temps init : " + init);
		System.out.println("Temps insertion : " + insert);
		System.out.println("Temps find : " + find);

		Connection.closeConnection();

	}

}
