package br.ufs.dcomp.sigaaweb.service;

import java.util.ArrayList;
import java.util.List;

import br.ufs.dcomp.sigaaweb.dao.DisciplinaDao;
import br.ufs.dcomp.sigaaweb.dao.TurmaDao;
import br.ufs.dcomp.sigaaweb.model.DisciplinaBean;
import br.ufs.dcomp.sigaaweb.model.Semestre;
import br.ufs.dcomp.sigaaweb.model.TurmaBean;

public class SemestreService {
	TurmaDao turmaDao = new TurmaDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	List<Semestre> semestres = new ArrayList<>();
	Semestre semestre = new Semestre();
	
	public List<Semestre>  buscarSemestre() {
		List<TurmaBean> turmaBeans = turmaDao.findAll();
		
		for (TurmaBean turmaBean : turmaBeans) {
			DisciplinaBean disciplinaBean = disciplinaDao.findByCodDisciplina(turmaBean.getCodDisciplina());
			
			semestre.setCodDisciplina(disciplinaBean.getCodDisciplina());
			semestre.setNomeDisciplina(disciplinaBean.getNomeDisciplina());
			
			semestre.setCodTurma(turmaBean.getCodTurma());
			
			// set horario da turma (manha, tarde, noite)
			if (turmaBean.getTurnoManha() != null) {
				semestre.setHorarioTurma(turmaBean.getTurnoManha());
			} else if (turmaBean.getTurnoTarde() != null) {
				semestre.setHorarioTurma(turmaBean.getTurnoTarde());
			} else if (turmaBean.getTurnoNoite() != null) {
				semestre.setHorarioTurma(turmaBean.getTurnoNoite());
			}
			
			this.semestres.add(semestre);
		}
		
		return this.semestres;
	}
}
