package testbdd1.model.dao;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.model.Personne;

public class DatabaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testStore() {

		Personne p = new Personne("p0");
		p.setNom("nom");
		p.setPrenom("prenom");
		p.setAdresse("adresse");

		// DB db = DBMaker.newMemoryDB().make();
		// DB db = Database.getDb();
		// ConcurrentNavigableMap<String, Personne> map = db.getTreeMap("TRUC");
		// map.put(p.getId(), p);
		// db.commit();

		Database.store(p.getId(), p);
		System.out.println(Database.getMap().get(p.getId()).toString());
		// db.close();
		Database.close();

	}

}
