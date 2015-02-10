package com.example.testjpa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	private Connection conn;

	public DAO(Connection conn) {
		this.conn = conn;
	}

	public boolean create(Personne p) {
		boolean result = false;
		Statement stmt;
		String sql;
		try {
			stmt = conn.createStatement();
			sql = "INSERT INTO PERSONNES VALUES ('" + p.getId() + "', '"
					+ p.getNom() + "', '" + p.getPrenom() + "', '"
					+ p.getAdresse() + "')";
			stmt.executeUpdate(sql);
			System.out.println("element insere");
			result = true;
		} catch (SQLException e) {
			System.out.println("Erreur sql");
			e.printStackTrace();
		}

		return result;

	}

	public Personne find(String id) {
		Personne p = null;

		try {
			ResultSet result = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
					"SELECT * FROM PERSONNES" + " WHERE id = '" + id + "'");

			if (result.first()) {
				p = new Personne();
				p.setNom(result.getString("nom"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

}
