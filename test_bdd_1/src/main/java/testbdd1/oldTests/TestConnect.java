package testbdd1.oldTests;

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

public class TestConnect {

	private static int MAX = 100;

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
		long deb, fin;
		deb = System.currentTimeMillis();

		conn = Connect.getConn();
		Connect.initDb(conn);
		dao = new DAO(conn);

		fin = System.currentTimeMillis();

		long init = fin - deb;

		System.out.println("test");

		deb = System.currentTimeMillis();

		int i = 0;
		for (i = 0; i < MAX; i++) {
			Date date = new Date();
			id = format.format(date) + System.nanoTime();
			p = new Personne(i);
			p.setNom("nom");
			p.setPrenom("prenom");
			p.setAdresse("adresse");

			dao.create(p);
		}

		fin = System.currentTimeMillis();

		long insert = fin - deb;
		System.out.println("entries : " + Connect.countEntries(conn));

		System.out.println("duree init : " + init);
		System.out.println("duree insert : " + insert);

	}

}
