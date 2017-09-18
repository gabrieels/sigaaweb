package br.ufs.dcomp.sigaaweb.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.model.CursoBean;

public class CursoDaoTest {
	private CursoBean cursoBean;
	private List<CursoBean> cursoBeanList;
	private CursoDao cursoDao = new CursoDao();

	@Test
	public final void testFindByCodCurso() {
		this.cursoBean = cursoDao.findByCodCurso(170);

		assertNotNull(cursoBean);
	}

	@Test
	public final void testFindAll() {
		this.cursoBeanList = cursoDao.findAll();

		assertNotNull(cursoBeanList);
	}
}
