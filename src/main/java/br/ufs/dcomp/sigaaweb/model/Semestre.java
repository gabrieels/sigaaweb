package br.ufs.dcomp.sigaaweb.model;

public class Semestre {
	private String codDisciplina;
	private String nomeDisciplina;
	private String cargaHoraria;
	private String codTurma;
	private String horarioTurma;
	
	public Semestre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codDisciplina
	 * @param nomeDisciplina
	 * @param cargaHoraria
	 * @param codTurma
	 * @param horarioTurma
	 */
	public Semestre(String codDisciplina, String nomeDisciplina, String cargaHoraria, String codTurma,
			String horarioTurma) {
		super();
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.codTurma = codTurma;
		this.horarioTurma = horarioTurma;
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

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public String getHorarioTurma() {
		return horarioTurma;
	}

	public void setHorarioTurma(String horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	@Override
	public String toString() {
		return "Semestre [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", cargaHoraria="
				+ cargaHoraria + ", codTurma=" + codTurma + ", horarioTurma=" + horarioTurma + "]\n";
	}
}
