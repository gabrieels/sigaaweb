package br.ufs.dcomp.sigaaweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.tool.ConnectionFactory;

public class AlunoDao {
	private Connection connection;
	private AlunoBean alunoBean = null;
	List<AlunoBean> alunoBeans = new ArrayList<>();
	
	public AlunoDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public AlunoBean findByMatricula(long matricula) {
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM alunos WHERE cod_matricula=" + matricula);

			if (resultSet.next()) {
				this.alunoBean = extractAlunoBeanFromResultSet(resultSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.alunoBean;
	}
	
	public List<AlunoBean> findAll() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM alunos");

			while (resultSet.next()) {
				this.alunoBean = extractAlunoBeanFromResultSet(resultSet);
				this.alunoBeans.add(alunoBean);
			}

		} catch (Exception e) {
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
