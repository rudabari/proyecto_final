package co.com.bancolombia.config;

import java.sql.*;

public class DbConnection {

	private final String DBNOMBRE = "proyecto_final";
	private final String USUARIO = "root";
	private final String PASSWORD = "root";
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNOMBRE + "?serverTimezone=UTC";

	private Connection connection;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return connection;

	}

}
