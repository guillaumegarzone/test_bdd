package com.example.testjpa;

import java.sql.Connection;
import java.sql.SQLException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getName();

	public static Connection conn;

	public static Personne p;

	public static DAO dao;

	static int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// init connection
		conn = Connect.getConn();
		try {
			Connect.initDb(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao = new DAO(conn);

		// add application code here
		Button buttonPersist = (Button) findViewById(R.id.button_persist);
		buttonPersist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Personne pers = new Personne("a" + id++);
				pers.setNom("nom");
				pers.setPrenom("prenom");
				pers.setAdresse("adresse");
				dao.create(pers);
			}
		});

		Button buttonFind = (Button) findViewById(R.id.button_find);
		buttonFind.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					displaySingleButtonDialog(Connect.findAll(conn));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		Log.i(TAG, "onCreate done");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	private void displaySingleButtonDialog(String text) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(text).setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// do things
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

}
