package br.ufs.dcomp.sigaaweb.service;

import java.util.List;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.dao.TurmaDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.model.TurmaBean;

public class AlunoService {
	AlunoDao alunoDao = new AlunoDao();
	TurmaDao turmaDao = new TurmaDao();
	AlunoBean alunoBean;
	TurmaBean turmaBean;
	List<AlunoBean> alunoBeans;
	List<TurmaBean> turmaBeans;

	public AlunoBean autenticar(long matricula) {
		alunoBean = alunoDao.findByMatricula(matricula);

		return alunoBean;
	}

	public AlunoBean buscarAluno(long matricula) {

		return this.alunoDao.findByMatricula(matricula);
	}

	public List<AlunoBean> listarAlunos() {
		return this.alunoDao.findAll();
	}
	
	public List<AlunoBean> buscarAlunosDisciplina(String codDisciplina) {
		return this.alunoDao.findByDisciplina(codDisciplina);
	}
}
