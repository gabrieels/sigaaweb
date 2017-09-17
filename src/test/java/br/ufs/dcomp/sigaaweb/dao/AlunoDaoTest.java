package br.ufs.dcomp.sigaaweb.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;

public class AlunoDaoTest {
	AlunoDao alunoDao = new AlunoDao();
	AlunoBean alunoBean;
	List<AlunoBean> alunoBeans;

	@Test
	public final void testFindByMatricula() {
		alunoBean = alunoDao.findByMatricula(201010012864L);
		System.out.println(alunoBean.toString());

		assertNotNull(alunoBean);
	}

	@Test
	public final void testFindAll() {
		alunoBeans = alunoDao.findAll();
		System.out.println(alunoBeans.toString());
		assertNotNull(alunoBeans);
	}
}
