package testbdd1.connection;

import java.sql.SQLException;

import testbdd1.model.Personne;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Connection {

	private static ConnectionSource conn;

	public final static String URL = "jdbc:h2:mem:account";

	public static ConnectionSource getConnection() {
		if (conn == null) {
			try {
				conn = new JdbcConnectionSource(URL + ";create=true");
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
		try {
			ConnectionSource connection = Connection.getConnection();
			TableUtils.createTableIfNotExists(connection, Personne.class);
			TableUtils.clearTable(connection, Personne.class);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
