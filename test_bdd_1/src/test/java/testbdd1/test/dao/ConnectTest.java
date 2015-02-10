package testbdd1.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.jdbc.Connect;
import testbdd1.jdbc.DAO;
import testbdd1.model.Personne;

public class ConnectTest {

	public static Connection conn;

	public static Personne p;

	public static DAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void test() throws SQLException {
		conn = Connect.getConn();
		Connect.initDb(conn);
		dao = new DAO(conn);
		System.out.println("test");
		p = new Personne("a0");
		p.setNom("nom");
		p.setPrenom("prenom");
		p.setAdresse("adresse");

		dao.create(p);

		p = new Personne("a1");
		dao.create(p);

		Connect.findAll(conn);

		// System.out.println(dao.find(p.getId()));

	}

}
