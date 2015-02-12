package testbdd1.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import testbdd1.model.Client;
import testbdd1.model.Personne;
import testbdd1.model.Projet;

public class DatabaseTest {

	public static Personne createPersonne(String id) {
		Personne p = new Personne(id);
		p.setNom("nom" + id);
		p.setPrenom("prenom" + id);
		p.setAdresse("adresse" + id);
		return p;
	}

	public static Client createClient(String id) {
		Client c = new Client(id);
		c.setNom("Cnom" + id);
		c.setPrenom("Cprenom" + id);
		c.setAdresse("Cadresse" + id);
		return c;
	}

	@Test
	public void testStore() {

		Personne p = createPersonne("p0");

		List<Projet> projets = new ArrayList<Projet>();
		Projet pr = new Projet();
		projets.add(pr);
		p.setProjets(projets);

		Client c = createClient("C0");
		c.setProjets(projets);

		Database.store(p.getId(), p);
		System.out.println(Database.getMap().get(p.getId()).toString());
		Database.store(c.getId(), c);
		System.out.println(Database.getMap().get(c.getId()).toString());
		Database.getDb().compact();
		// db.close();
		Database.close();

	}
}
