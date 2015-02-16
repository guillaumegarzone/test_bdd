package testbdd1.connection;

import java.sql.SQLException;

import testbdd1.model.Personne;
import testbdd1.model.Projet;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ConnectionH2 {

	private static ConnectionSource conn;

	public final static String URL = "jdbc:h2:~/BddTest/testH2.db;create=true";
	public final static String CRYPT = ";CIPHER=AES";

	public static ConnectionSource getConnection() {
		if (conn == null) {
			try {
				String user = "test";
				String pwd = "test";
				// String cpwd = "test test";
				conn = new JdbcConnectionSource(URL, user, pwd);
				// conn = new JdbcConnectionSource(URL+CRYPT, user, cpwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static boolean initDb() {
		boolean result = false;
		ConnectionSource connection = ConnectionH2.getConnection();
		try {
			TableUtils.dropTable(connection, Projet.class, true);
			TableUtils.dropTable(connection, Personne.class, true);
			TableUtils.createTableIfNotExists(connection, Projet.class);
			TableUtils.createTableIfNotExists(connection, Personne.class);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// try {
		// TableUtils.clearTable(connection, Projet.class);
		// TableUtils.clearTable(connection, Personne.class);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		return result;
	}

}
