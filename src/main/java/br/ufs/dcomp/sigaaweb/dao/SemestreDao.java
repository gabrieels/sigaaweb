package br.ufs.dcomp.sigaaweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.SemestreBean;
import br.ufs.dcomp.sigaaweb.util.GenericDao;

public class SemestreDao extends GenericDao {
	private SemestreBean semestreBean;
	private List<SemestreBean> semestreBeans = new ArrayList<>();

	public SemestreDao() {
		super();
	}

	public List<SemestreBean> findAll() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT "
					+ "t1.cod_disciplina, "
					+ "t2.nome_disciplina, "
					+ "t2.nu_creditos, "
					+ "t1.cod_turma, "
					+ "t1.turno_manha, "
					+ "t1.turno_tarde, "
					+ "t1.turno_noite "
					+ "FROM listaweb1.turmas t1 inner join listaweb1.disciplinas t2 "
					+ "on t1.cod_disciplina = t2.cod_disciplina");

			while (resultSet.next()) {
				this.semestreBean = extractSemestreBeanFromResultSet(resultSet);
				this.semestreBeans.add(semestreBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeConnection();
		}

		return this.semestreBeans;
	}

	private SemestreBean extractSemestreBeanFromResultSet(ResultSet resultSet) throws SQLException {
		SemestreBean semestreBean = new SemestreBean();

		semestreBean.setCodDisciplina(resultSet.getString("cod_disciplina"));
		semestreBean.setNomeDisciplina(resultSet.getString("nome_disciplina"));
		semestreBean.setCargaHoraria(resultSet.getString("nu_creditos"));
		semestreBean.setCodTurma(resultSet.getString("cod_turma"));

		if (resultSet.getString("turno_manha") != null) {
			semestreBean.setHorarioTurma(resultSet.getString("turno_manha"));
		} else if (resultSet.getString("turno_tarde") != null) {
			semestreBean.setHorarioTurma(resultSet.getString("turno_tarde"));
		} else if (resultSet.getString("turno_noite") != null) {
			semestreBean.setHorarioTurma(resultSet.getString("turno_noite"));
		}

		return semestreBean;
	}
}
