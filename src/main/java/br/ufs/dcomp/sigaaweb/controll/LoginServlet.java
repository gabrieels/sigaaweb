package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.service.AlunoService;

@WebServlet(name = "LoginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	long matricula = 0;
	AlunoDao alunoDao = new AlunoDao();
	AlunoService alunoService;
	AlunoBean alunoBean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter out = resp.getWriter();
			alunoBean = new AlunoBean();

			matricula = Long.parseLong(req.getParameter("usermatricula"));

			alunoBean = alunoDao.findByMatricula(matricula);

			if (alunoBean != null) {
				resp.setContentType("text/html");
				out.println("Ola " + alunoBean.getNomeAluno());
			} else {
				resp.setContentType("text/html");
				out.println("Error: Matricula inválida");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
