package testbdd1.model.dao;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import testbdd1.model.Personne;

public class MapDBTest {

	private static final int MAX = 1000;
	private static final String COLLECTION_NAME = "testMem";
	private static final String PATH = "src/main/resources/bdd/bdd";

	@Test
	public void test() {
		DB db = DBMaker.newMemoryDB().make();
		ConcurrentNavigableMap<String, Personne> map = db
				.getTreeMap(COLLECTION_NAME);

		int i;
		long deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = DatabaseTest.createPersonne("p" + i);
			map.put("p" + i, p);
			db.commit();
		}
		long fin = System.currentTimeMillis();
		long insert = fin - deb;
		System.out.println("duree insert MEM :" + insert);
		db.close();
	}

	@Test
	public void testFile() {
		DB db = DBMaker.newFileDB(new File(PATH)).make();
		ConcurrentNavigableMap<String, Personne> map = db
				.getTreeMap(COLLECTION_NAME);

		int i;
		long deb = System.currentTimeMillis();
		for (i = 0; i < MAX; i++) {
			Personne p = DatabaseTest.createPersonne("p" + i);
			map.put("p" + i, p);
			db.commit();
		}
		long fin = System.currentTimeMillis();
		long insert = fin - deb;
		System.out.println("duree insert FILE :" + insert);
		db.close();
	}
}
