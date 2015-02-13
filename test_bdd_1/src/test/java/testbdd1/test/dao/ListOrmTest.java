package testbdd1.test.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import testbdd1.connection.ConnectionSqlite;
import testbdd1.dao.DAO;
import testbdd1.model.Personne;
import testbdd1.model.Projet;

import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;

public class ListOrmTest {

	private DAO<Personne, Integer> personneDao;
	private ConnectionSource conn;
	private DAO<Projet, Integer> projetDao;

	@Test
	public void test() throws SQLException {
		// long deb, fin;

		System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "debug");

		// deb = System.currentTimeMillis();
		conn = ConnectionSqlite.getConnection();
		assertTrue(ConnectionSqlite.initDb());
		// fin = System.currentTimeMillis();
		personneDao = new DAO<Personne, Integer>(conn, Personne.class);
		projetDao = new DAO<Projet, Integer>(conn, Projet.class);
		// long init = fin - deb;

		Personne p = new Personne();
		p.setNom("nom");
		p.setPrenom("prenom");
		p.setAdresse("adresse");

		Collection<Projet> projets = new ArrayList<Projet>();
		Projet proj = new Projet();
		proj.setNom("nomProj");
		projets.add(proj);

		p.setProjets(projets);
		proj.setPersonne(p);

		// Projet pr = new Projet();
		// pr.setNom("nomProjet");
		// Personne responsable = new Personne();
		// responsable.setNom("responsable");
		// pr.setResponsable(responsable);
		// p.setProjet(pr);

		personneDao.create(p);
		projetDao.create(proj);

		Personne p2 = personneDao.find(1);
		System.out.println(p2.toString());
		System.out.println(p2.getProjets().size());
	}
}
