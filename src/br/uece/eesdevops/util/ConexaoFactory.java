package br.uece.eesdevops.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/eesdevops";
	private static final String USUARIO = "postgres";
	private static final String SENHA= "postgres";

	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
