package testbdd1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public static Connection getConn() {
		Connection c = null;
		try {
			String url = "jdbc:h2:mem:testh2;create=true";
			String user = "testh2";
			String passwd = "testh2";
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			c = conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static boolean initDb(Connection conn) throws SQLException {
		System.out.println("creation des tables");
		boolean result = false;
		Statement stmt;
		stmt = conn.createStatement();
		String sql;
		String tableName = "PERSONNES";

		sql = "CREATE TABLE " + tableName + " " + "(id VARCHAR(50) not NULL, "
				+ "nom VARCHAR(255), " + "prenom VARCHAR(225), "
				+ "adresse VARCHAR(225), " + " PRIMARY KEY ( id ));";

		stmt.execute(sql);
		System.out.println("table cree");

		return result;
	}

	public static void fuck(Connection conn) throws SQLException {
		ResultSet result = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT * FROM PERSONNES");

		// System.out.println(result.getString("id"));
		while (result.next()) {
			System.out.println(result.getString("id"));
		}
		System.out.println(result.toString());

	}
}
