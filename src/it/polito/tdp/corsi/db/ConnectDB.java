package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection() {

		try {

			String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=a123$456&serverTimezone=Europe/Rome";
			Connection conn = DriverManager.getConnection(jdbcURL);
			return conn;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("errore connessione al DB");
			throw new RuntimeException();
		}

	}
}
