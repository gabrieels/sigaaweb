package br.ufs.dcomp.sigaaweb.model;

import br.ufs.dcomp.sigaaweb.util.BaseBean;

public class DisciplinaBean extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String codDisciplina;
	private String nomeDisciplina;
	private String nuCreditos;
	
	public DisciplinaBean() {
	}
	
	/**
	 * @param codDisciplina
	 * @param nomeDisciplina
	 * @param nuCreditos
	 */
	public DisciplinaBean(String codDisciplina, String nomeDisciplina, String nuCreditos) {
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.nuCreditos = nuCreditos;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNuCreditos() {
		return nuCreditos;
	}

	public void setNuCreditos(String nuCreditos) {
		this.nuCreditos = nuCreditos;
	}

	@Override
	public String toString() {
		return "DisciplinaBean [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", nuCreditos="
				+ nuCreditos + "]\n";
	}
}
