package testbdd1.test.dao;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.model.Personne;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class OrmTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws SQLException {

		String url = "jdbc:h2:mem:account;create=true";

		ConnectionSource connectionSource = new JdbcConnectionSource(url);

		Dao<Personne, Integer> personneDao = DaoManager.createDao(
				connectionSource, Personne.class);

		TableUtils.createTable(connectionSource, Personne.class);

		Personne p = new Personne(0);
		p.setNom("nomPersonne");
		personneDao.create(p);

		Personne pers = personneDao.queryForId(p.getId());

		System.out.println(pers.toString());

		connectionSource.close();

	}

	@Test
	public void test2() throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:test.db;create=true";

		ConnectionSource connectionSource = new JdbcConnectionSource(url);

		Dao<Personne, Integer> personneDao = DaoManager.createDao(
				connectionSource, Personne.class);

		TableUtils.createTable(connectionSource, Personne.class);

		Personne p = new Personne(0);
		p.setNom("nomPersonne");
		personneDao.create(p);

		Personne pers = personneDao.queryForId(p.getId());

		System.out.println(pers.toString());

		connectionSource.close();

	}
}
