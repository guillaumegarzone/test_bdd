package com.example.testjpa;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import android.util.Log;

public class H2Connection implements Closeable {
	private static final String TAG = H2Connection.class.getName();
	private Connection conn;

	public H2Connection() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDB() {
		try {
			Statement stat = conn.createStatement();
			String sql = "CREATE TABLE PERSONNES(id int primary key, name varchar(255))";
			stat.execute(sql);
			Log.i(TAG, "table PERSONNES created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
