package br.ufs.dcomp.sigaaweb.model;

import br.ufs.dcomp.sigaaweb.tool.BaseBean;

public class TurmaBean extends BaseBean {
	
	private String codDisciplina;
	private String codTurma;
	private String turnoManha;
	private String turnoTarde;
	private String turnoNoite;
	
	/**
	 * @param codDisciplina
	 * @param codTurma
	 * @param turnoManha
	 * @param turnoTarde
	 * @param turnoNoite
	 */
	public TurmaBean(String codDisciplina, String codTurma, String turnoManha, String turnoTarde, String turnoNoite) {
		this.codDisciplina = codDisciplina;
		this.codTurma = codTurma;
		this.turnoManha = turnoManha;
		this.turnoTarde = turnoTarde;
		this.turnoNoite = turnoNoite;
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

	public String getTurnoManha() {
		return turnoManha;
	}

	public void setTurnoManha(String turnoManha) {
		this.turnoManha = turnoManha;
	}

	public String getTurnoTarde() {
		return turnoTarde;
	}

	public void setTurnoTarde(String turnoTarde) {
		this.turnoTarde = turnoTarde;
	}

	public String getTurnoNoite() {
		return turnoNoite;
	}

	public void setTurnoNoite(String turnoNoite) {
		this.turnoNoite = turnoNoite;
	}

	@Override
	public String toString() {
		return "TurmaBean [codDisciplina=" + codDisciplina + ", codTurma=" + codTurma + ", turnoManha=" + turnoManha
				+ ", turnoTarde=" + turnoTarde + ", turnoNoite=" + turnoNoite + "]";
	}
}
