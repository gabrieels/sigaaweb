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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM turmas");

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
			semestreBean.setCargaHoraria(resultSet.getString("turno_tarde"));
		} else if (resultSet.getString("turno_noite") != null) {
			semestreBean.setHorarioTurma(resultSet.getString("turno_noite"));
		}

		return semestreBean;
	}
}
