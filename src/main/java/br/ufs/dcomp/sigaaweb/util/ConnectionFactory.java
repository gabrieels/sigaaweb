package br.ufs.dcomp.sigaaweb.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/listaweb1?autoReconnect=true&useSSL=false";
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DATABASE_URL, "freire", "freire");
		} catch (SQLException | ClassNotFoundException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}
}
