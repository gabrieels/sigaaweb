package br.ufs.dcomp.sigaaweb.model;

import br.ufs.dcomp.sigaaweb.util.BaseBean;

public class AlunoBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private long codMatricula;
	private String nomeAluno;
	private String codCurso;
	
	public AlunoBean() {
	}
	
	/**
	 * @param codMatricula
	 * @param nomeAluno
	 * @param codDisciplina
	 * @param codTurma
	 * @param codCurso
	 */
	public AlunoBean(long codMatricula, String nomeAluno, String codCurso) {
		this.codMatricula = codMatricula;
		this.nomeAluno = nomeAluno;
		this.codCurso = codCurso;
	}

	public long getCodMatricula() {
		return codMatricula;
	}

	public void setCodMatricula(long codMatricula) {
		this.codMatricula = codMatricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		return "AlunoBean [codMatricula=" + codMatricula + ", nomeAluno=" + nomeAluno + ", codCurso=" + codCurso + "]\n";
	}
}
