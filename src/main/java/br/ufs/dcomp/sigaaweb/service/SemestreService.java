package br.ufs.dcomp.sigaaweb.service;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.dao.SemestreDao;
import br.ufs.dcomp.sigaaweb.model.SemestreBean;

public class SemestreService {
	SemestreDao semestreDao = new SemestreDao();
	List<SemestreBean> semestres = new ArrayList<>();
	
	public List<SemestreBean>  buscarSemestre() {
		this.semestres = semestreDao.findAll();
		
		return this.semestres;
	}
}
