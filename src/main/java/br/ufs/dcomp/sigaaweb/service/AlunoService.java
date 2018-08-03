package br.ufs.dcomp.sigaaweb.service;

import java.util.List;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;

public class AlunoService {
    private AlunoDao alunoDao = new AlunoDao();
    private AlunoBean alunoBean;

    public AlunoBean autenticar(long matricula) {
        alunoBean = alunoDao.findByMatricula(matricula);
        return alunoBean;
    }

    public AlunoBean buscarAluno(long matricula) {
        if (matricula == 0) {
            return  null;
        }
        return this.alunoDao.findByMatricula(matricula);
    }

    public List<AlunoBean> listarAlunos() {
        return this.alunoDao.findAll();
    }

//    public List<AlunoBean> buscarAlunosDisciplina(String codDisciplina) {
//        return this.alunoDao.findByDisciplina(codDisciplina);
//    }

    public List<AlunoBean> buscarAlunosByDisciplinaByTurma(String codDisciplina, String codTurma) {
        //return this.alunoDao.findByDisciplinaTurma(codDisciplina, codTurma);
        return null;
    }
}
