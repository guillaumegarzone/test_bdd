package testbdd1.model.dao;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

public class Database {

	private static final String COLLECTION_NAME = "test";
	private static DB db;

	public static DB getDb() {
		if (db == null)
			DBMaker.newMemoryDB().make();

		return db;
	}

	public static void store(String id, Object obj) {
		BTreeMap<String, Object> map = db.getTreeMap(COLLECTION_NAME);

		map.put(id, obj);

		getDb().commit();
	}

	public static void close() {
		if (db != null)
			db.close();
		db = null;
	}
}
