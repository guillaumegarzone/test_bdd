package testbdd1.connection;

import java.sql.SQLException;

import testbdd1.model.Personne;
import testbdd1.model.Projet;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.DerbyEmbeddedDatabaseType;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ConnectionDerby {

	private static ConnectionSource conn;

	public final static String URL = "jdbc:derby:~/BddTest/test";

	public static ConnectionSource getConnection() {
		if (conn == null) {
			try {
				DatabaseType databaseType = new DerbyEmbeddedDatabaseType();
				String user = "test";
				String pwd = "test";

				conn = new JdbcConnectionSource(URL + ";create=true", user,
						pwd, databaseType);
				// conn = new Jd
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
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			TableUtils.createTableIfNotExists(connection, Projet.class);
			TableUtils.createTableIfNotExists(connection, Personne.class);
			result = result & true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
