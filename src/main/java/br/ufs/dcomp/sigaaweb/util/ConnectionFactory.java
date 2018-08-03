package br.ufs.dcomp.sigaaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/listaweb1?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DATABASE_URL, "root", "nov@er@");
		} catch (SQLException | ClassNotFoundException sqlException) {
			System.out.println("###### Erro na conexao!! ######");
			throw new RuntimeException(sqlException);
		}
	}
}
