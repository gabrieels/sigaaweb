package br.ufs.dcomp.sigaaweb.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.model.DisciplinaBean;

public class DisciplinaDaoTest {

	private DisciplinaBean disciplinaBean;
	private List<DisciplinaBean> disciplinaBeanList;
	private DisciplinaDao disciplinaDao = new DisciplinaDao();

	@Test
	public final void testFindByCodDisciplina() {
		this.disciplinaBean = disciplinaDao.findByCodDisciplina("COMP0199");
		
		assertNotNull(disciplinaBean);
	}

	@Test
	public final void testFindAll() {
		this.disciplinaBeanList = disciplinaDao.findAll();
		
		assertNotNull(disciplinaBeanList);
	}
}
