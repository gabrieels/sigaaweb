package br.ufs.dcomp.sigaaweb.service;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;

public class AlunoService {
	AlunoDao alunoDao = new AlunoDao();
	AlunoBean alunoBean;

	public AlunoBean buscaAluno(long matricula) {
		if (matricula != 0) {
			alunoBean = alunoDao.findByMatricula(matricula);
			if (alunoBean != null) {
				return alunoBean;
			} 
		} 
		
		return null;
	}
}
