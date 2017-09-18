package br.ufs.dcomp.sigaaweb.model;

import br.ufs.dcomp.sigaaweb.util.BaseBean;

public class CursoBean extends BaseBean {
	private static final long serialVersionUID = 1L;
	private int codCurso;
	private String nomeCurso;
	
	public CursoBean() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param codCurso
	 * @param nomeCurso
	 */
	public CursoBean(int codCurso, String nomeCurso) {
		this.codCurso = codCurso;
		this.nomeCurso = nomeCurso;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "CursoBean [codCurso=" + codCurso + ", nomeCurso=" + nomeCurso + "]";
	}
}