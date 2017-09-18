package br.ufs.dcomp.sigaaweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.util.GenericDao;

public class AlunoDao extends GenericDao {
	private AlunoBean alunoBean = null;
	List<AlunoBean> alunoBeans = new ArrayList<>();
	
	public AlunoDao() {
		super();
	}

	public AlunoBean findByMatricula(long matricula) {
		
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM alunos WHERE cod_matricula=" + matricula);

			if (resultSet.next()) {
				this.alunoBean = extractAlunoBeanFromResultSet(resultSet);
			}
			
			statement.close();
			this.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.alunoBean;
	}
	
	public List<AlunoBean> findAll() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM alunos");

			while (resultSet.next()) {
				this.alunoBean = extractAlunoBeanFromResultSet(resultSet);
				this.alunoBeans.add(alunoBean);
			}
			
			statement.close();
			this.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.alunoBeans;
	}

	private AlunoBean extractAlunoBeanFromResultSet(ResultSet resultSet) throws SQLException {
		AlunoBean alunoBean = new AlunoBean();

		alunoBean.setCodCurso(resultSet.getString("cod_matricula"));
		alunoBean.setNomeAluno(resultSet.getString("nome_aluno"));
		alunoBean.setCodDisciplina(resultSet.getString("cod_disciplina"));
		alunoBean.setCodTurma(resultSet.getString("cod_turma"));
		alunoBean.setCodCurso(resultSet.getString("cod_curso"));

		return alunoBean;
	}
}
