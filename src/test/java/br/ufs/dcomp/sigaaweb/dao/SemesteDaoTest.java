package br.ufs.dcomp.sigaaweb.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.model.SemestreBean;

public class SemesteDaoTest {
	private List<SemestreBean> semestreBeans;
	private SemestreDao semestreDao = new SemestreDao();

	@Test
	public final void testFindAll() {
		this.semestreBeans = semestreDao.findAll();

		assertNotNull(this.semestreBeans);
	}
}
