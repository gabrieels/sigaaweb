package br.ufs.dcomp.sigaaweb.service;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;

public class AlunoService {
	AlunoDao alunoDao = new AlunoDao();
	AlunoBean alunoBean;

	public AlunoBean autenticar(long matricula) {
		alunoBean = alunoDao.findByMatricula(matricula);
		
		return alunoBean;
	}
}
