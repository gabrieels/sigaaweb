package br.ufs.dcomp.sigaaweb.service;

import java.util.List;

import br.ufs.dcomp.sigaaweb.dao.DisciplinaDao;
import br.ufs.dcomp.sigaaweb.model.DisciplinaBean;

public class DisciplinaService {
	DisciplinaBean disciplinaBean;
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	List<DisciplinaBean> disciplinaBeans;

	public DisciplinaBean buscarDisciplina(String codDisciplina) {
		return this.disciplinaDao.findByCodDisciplina(codDisciplina);
	}

	public List<DisciplinaBean> listarDisciplinas() {
		return this.disciplinaDao.findAll();
	}
}
