package br.ufs.dcomp.sigaaweb.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.model.TurmaBean;

public class TurmaDaoTest {
	private TurmaDao turmaDao = new TurmaDao();
	private TurmaBean turmaBean;
	private List<TurmaBean> turmaBeanList;

	@Test
	public final void testFindbyCodTurma() {
		turmaBean = turmaDao.findbyCodTurma("COMP0199", "T01");
		
		assertNotNull(turmaBean);
	}

	@Test
	public final void testFindAll() {
		turmaBeanList = turmaDao.findAll();
		System.out.println(turmaBeanList.toString());
		assertNotNull(turmaBeanList);
	}

}
