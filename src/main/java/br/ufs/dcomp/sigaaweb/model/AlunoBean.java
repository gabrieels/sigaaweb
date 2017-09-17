package br.ufs.dcomp.sigaaweb.model;

import br.ufs.dcomp.sigaaweb.tool.BaseBean;

public class AlunoBean extends BaseBean {
	private long codMatricula;
	private String nomeAluno;
	private String codDisciplina;
	private String codTurma;
	private String codCurso;
	
	/**
	 * @param codMatricula
	 * @param nomeAluno
	 * @param codDisciplina
	 * @param codTurma
	 * @param codCurso
	 */
	public AlunoBean(long codMatricula, String nomeAluno, String codDisciplina, String codTurma, String codCurso) {
		this.codMatricula = codMatricula;
		this.nomeAluno = nomeAluno;
		this.codDisciplina = codDisciplina;
		this.codTurma = codTurma;
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

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		return "AlunoBean [codMatricula=" + codMatricula + ", nomeAluno=" + nomeAluno + ", codDisciplina="
				+ codDisciplina + ", codTurma=" + codTurma + ", codCurso=" + codCurso + "]";
	}
}
