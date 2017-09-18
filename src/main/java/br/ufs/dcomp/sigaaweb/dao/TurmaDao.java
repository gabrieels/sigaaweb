package br.ufs.dcomp.sigaaweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.TurmaBean;
import br.ufs.dcomp.sigaaweb.util.GenericDao;

public class TurmaDao extends GenericDao {
	private TurmaBean turmaBean = null;
	private List<TurmaBean> turmaBeans = new ArrayList<>();

	public TurmaDao() {
		super();
	}

	public TurmaBean findbyCodTurma(String codDisciplina, String codTurma) {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM turmas WHERE cod_disciplina='" + codDisciplina
					+ "' AND cod_turma ='" + codTurma + "'");

			if (resultSet.next()) {
				this.turmaBean = extractTurmaBeanFromResultSet(resultSet);
			}
			
			statement.close();
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.turmaBean;
	}

	public List<TurmaBean> findAll() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM turmas");

			while (resultSet.next()) {
				this.turmaBean = extractTurmaBeanFromResultSet(resultSet);
				this.turmaBeans.add(turmaBean);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

		return this.turmaBeans;
	}

	private TurmaBean extractTurmaBeanFromResultSet(ResultSet resultSet) throws SQLException {
		TurmaBean bean = new TurmaBean();

		bean.setCodDisciplina(resultSet.getString("cod_disciplina"));
		bean.setCodTurma(resultSet.getString("cod_turma"));
		bean.setTurnoManha(resultSet.getString("turno_manha"));
		bean.setTurnoTarde(resultSet.getString("turno_tarde"));
		bean.setTurnoNoite(resultSet.getString("turno_noite"));

		return bean;
	}
}
