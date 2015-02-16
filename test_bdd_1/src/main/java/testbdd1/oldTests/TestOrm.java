package testbdd1.oldTests;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.model.Personne;
import testbdd1.model.Projet;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class TestOrm {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "trace");
	}

	@Test
	public void test() throws SQLException, ClassNotFoundException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		System.out.println("TEST DERBY");
		String url = "jdbc:derby:mem:account;create=true";

		ConnectionSource connectionSource = new JdbcConnectionSource(url);

		Dao<Personne, Integer> personneDao = DaoManager.createDao(
				connectionSource, Personne.class);

		TableUtils.createTable(connectionSource, Personne.class);
		TableUtils.createTable(connectionSource, Projet.class);

		Personne p = new Personne(0);
		p.setNom("nomPersonne");
		personneDao.create(p);

		Personne pers = personneDao.queryForId(p.getId());

		System.out.println(pers.toString());

		connectionSource.close();

	}

	@Test
	public void test2() throws SQLException, ClassNotFoundException {
		System.out.println("TEST SQLite");
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:test.db";

		ConnectionSource connectionSource = new JdbcConnectionSource(url);

		Dao<Personne, Integer> personneDao = DaoManager.createDao(
				connectionSource, Personne.class);

		TableUtils.createTableIfNotExists(connectionSource, Personne.class);
		TableUtils.clearTable(connectionSource, Personne.class);
		TableUtils.createTableIfNotExists(connectionSource, Projet.class);
		TableUtils.clearTable(connectionSource, Projet.class);

		Personne p = new Personne(0);
		p.setNom("nomPersonne");
		personneDao.create(p);

		Personne pers = personneDao.queryForId(p.getId());

		System.out.println(pers.toString());

		connectionSource.close();

	}
}
