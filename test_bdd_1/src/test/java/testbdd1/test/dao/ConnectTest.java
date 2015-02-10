package testbdd1.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.jdbc.Connect;
import testbdd1.jdbc.DAO;
import testbdd1.model.Personne;

public class ConnectTest {

	private static int MAX = 100000;

	public static Connection conn;

	public static Personne p;

	public static DAO dao;

	public static String id;

	public static DateFormat format = new SimpleDateFormat(
			"yy-MM-dd-HH-mm-ss-SSS");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void test() throws SQLException {
		long deb = System.currentTimeMillis();

		conn = Connect.getConn();
		Connect.initDb(conn);
		dao = new DAO(conn);

		System.out.println("test");

		int i = 0;
		for (i = 0; i < MAX; i++) {
			Date date = new Date();
			id = format.format(date) + System.nanoTime();
			p = new Personne(id);
			p.setNom("nom");
			p.setPrenom("prenom");
			p.setAdresse("adresse");

			dao.create(p);
		}

		System.out.println("entries : " + Connect.countEntries(conn));

		long fin = System.currentTimeMillis();

		System.out.println("duree : " + (fin - deb));

	}

}
