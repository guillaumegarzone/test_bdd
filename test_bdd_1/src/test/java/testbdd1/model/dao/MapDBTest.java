package testbdd1.model.dao;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import testbdd1.model.Client;
import testbdd1.model.Personne;

public class MapDBTest {

	private static final int MAX1 = 100;
	private static final int MAX2 = 1000;
	private static final int MAX3 = 10000;
	private static final String COLLECTION_NAME = "testMem";
	private static final String PATH = "src/main/resources/bdd/bdd";

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

	public void test(int max) {
		DB db = DBMaker.newMemoryDB().make();
		ConcurrentNavigableMap<String, Personne> map = db
				.getTreeMap(COLLECTION_NAME + max);

		int i;
		long deb = System.currentTimeMillis();
		for (i = 0; i < max; i++) {
			Personne p = DatabaseTest.createPersonne("p" + i);
			map.put("p" + i, p);
			db.commit();
		}
		long fin = System.currentTimeMillis();
		long insert = fin - deb;
		System.out.println("duree " + max + " insert MEM :" + insert);
		db.close();
	}

	public void testFile(int max) {
		DB db = DBMaker.newFileDB(new File(PATH + max + "f")).make();
		ConcurrentNavigableMap<String, Personne> map = db
				.getTreeMap(COLLECTION_NAME + max);

		int i;
		long deb = System.currentTimeMillis();
		for (i = 0; i < max; i++) {
			Personne p = DatabaseTest.createPersonne("p" + i);
			map.put("p" + i, p);
			db.commit();
		}
		long fin = System.currentTimeMillis();
		long insert = fin - deb;
		System.out.println("duree " + max + " insert FILE :" + insert);
		db.close();
	}

	@Test
	public void mainTest() {
		// Thread t1 = new Thread() {
		// @Override
		// public void run() {
		// test(MAX1);
		// }
		// };
		// t1.start();
		//
		// Thread t2 = new Thread() {
		// @Override
		// public void run() {
		// test(MAX2);
		// }
		// };
		// t2.start();
		//
		// Thread t3 = new Thread() {
		// @Override
		// public void run() {
		// test(MAX3);
		// }
		// };
		// t3.start();

		Thread t4 = new Thread() {
			@Override
			public void run() {
				testFile(MAX1);
			}
		};
		t4.start();

		Thread t5 = new Thread() {
			@Override
			public void run() {
				testFile(MAX2);
			}
		};
		t5.start();

		Thread t6 = new Thread() {
			@Override
			public void run() {
				testFile(MAX3);
			}
		};
		t6.start();
		try {
			// t1.join();
			// t2.join();
			// t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
