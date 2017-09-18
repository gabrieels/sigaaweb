package br.ufs.dcomp.sigaaweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.DisciplinaBean;
import br.ufs.dcomp.sigaaweb.util.GenericDao;

public class DisciplinaDao extends GenericDao {
	private DisciplinaBean disciplinaBean;
	private List<DisciplinaBean> disciplinaBeans = new ArrayList<>();

	public DisciplinaDao() {
		super();
	}

	public DisciplinaBean findByCodDisciplina(String codDisciplina) {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM disciplinas WHERE cod_disciplina='" + codDisciplina + "'");

			if (resultSet.next()) {
				this.disciplinaBean = extractDisciplinaBeanFromResultSet(resultSet);
			}
			
			statement.close();
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.disciplinaBean;
	}

	public List<DisciplinaBean> findAll() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM disciplinas");

			while (resultSet.next()) {
				this.disciplinaBean = extractDisciplinaBeanFromResultSet(resultSet);
				this.disciplinaBeans.add(disciplinaBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.disciplinaBeans;
	}

	private DisciplinaBean extractDisciplinaBeanFromResultSet(ResultSet resultSet) throws SQLException {
		DisciplinaBean bean = new DisciplinaBean();

		bean.setCodDisciplina(resultSet.getString("cod_disciplina"));
		bean.setNomeDisciplina(resultSet.getString("nome_disciplina"));
		bean.setNuCreditos(resultSet.getString("nu_creditos"));

		return bean;
	}
}
