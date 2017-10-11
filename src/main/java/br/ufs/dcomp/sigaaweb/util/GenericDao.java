package br.ufs.dcomp.sigaaweb.util;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDao {
	private Connection connection;

	public GenericDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexao:" + e.getMessage());
		}
	}
}
