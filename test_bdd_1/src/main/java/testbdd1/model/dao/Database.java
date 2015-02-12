package testbdd1.model.dao;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import testbdd1.model.Personne;

public class Database {

	private static final String COLLECTION_NAME = "test";
	private static final String PATH = "src/main/resources/bdd/bdd";
	private static DB db;
	private static ConcurrentNavigableMap<String, Personne> map;

	public static DB getDb() {
		if (db == null) {
			db = DBMaker.newFileDB(new File(PATH)).make();
			// db = DBMaker.newMemoryDB().make();
		}

		return db;
	}

	public static ConcurrentNavigableMap<String, Personne> getMap() {
		if (map == null)
			map = getDb().getTreeMap(COLLECTION_NAME);
		return map;
	}

	public static void store(String id, Personne obj) {

		// BTreeMap<String, Object> map = getDb().getTreeMap(COLLECTION_NAME);
		getMap().put(id, obj);
		getDb().commit();
	}

	public static void close() {
		if (db != null)
			db.close();
		db = null;
	}
}
