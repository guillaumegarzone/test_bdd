package testbdd1.connection;

import java.sql.SQLException;

import testbdd1.model.Personne;
import testbdd1.model.Projet;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ConnectionSqlite {

	private static ConnectionSource conn;

	public final static String URL = "jdbc:sqlite:test.db";

	public static ConnectionSource getConnection() {
		if (conn == null) {
			try {
				Class.forName("org.sqlite.JDBC");
				conn = new JdbcConnectionSource(URL);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
		try {
			ConnectionSource connection = ConnectionSqlite.getConnection();
			TableUtils.createTableIfNotExists(connection, Projet.class);
			TableUtils.clearTable(connection, Projet.class);
			TableUtils.createTableIfNotExists(connection, Personne.class);
			TableUtils.clearTable(connection, Personne.class);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
