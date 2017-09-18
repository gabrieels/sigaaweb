package br.ufs.dcomp.sigaaweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.CursoBean;
import br.ufs.dcomp.sigaaweb.util.GenericDao;

public class CursoDao extends GenericDao {
	private CursoBean cursoBean;
	private List<CursoBean> cursoBeans = new ArrayList<>();

	public CursoDao() {
		super();
	}

	public CursoBean findByCodCurso(int codCurso) {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cursos WHERE cod_curso=" + codCurso);
			if (resultSet.next()) {
				this.cursoBean = extractCursoBeanFromResultSet(resultSet);
			}

			statement.close();
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.cursoBean;
	}

	public List<CursoBean> findAll() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cursos");

			while (resultSet.next()) {
				this.cursoBean = extractCursoBeanFromResultSet(resultSet);
				this.cursoBeans.add(cursoBean);
			}

			statement.close();
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.cursoBeans;
	}

	private CursoBean extractCursoBeanFromResultSet(ResultSet resultSet) throws SQLException {
		CursoBean bean = new CursoBean();

		bean.setCodCurso(resultSet.getInt("cod_curso"));
		bean.setNomeCurso(resultSet.getString("nome_curso"));

		return bean;
	}
}
